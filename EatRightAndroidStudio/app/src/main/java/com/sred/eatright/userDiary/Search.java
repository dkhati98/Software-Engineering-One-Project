package com.sred.eatright.userDiary;

//import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sred.eatright.FoodForSearchBar;
import com.sred.eatright.R;
import com.sred.eatright.searchFood.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import searchWithBarcode.BarcodeResult;

import com.sred.eatright.searchFood.Example;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;
import static com.sred.eatright.searchFood.Api.BASE_URL;

//import android.content.Intent;
//import android.util.Log;
//import android.widget.ImageView;
//import java.util.List;

//import static com.sred.eatright.com.sred.eatright.searchFood.Api.BASE_URL;

public class Search extends Fragment
{
    View myView;
    SearchView searchBar;
    ImageButton scanButton;
    ListView searchResult;
    Button customFood;
    String found = "N";
    static final int CONTACT_REQUEST =1;

    int _id;
    String mealType;

    ArrayList<FoodForSearchBar> allFoods = new ArrayList<FoodForSearchBar>();
    ArrayList<FoodForSearchBar>filteredFoodList = new ArrayList<FoodForSearchBar>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        final String id = getArguments().getString("id","0");

        _id= Integer.parseInt(id);

         mealType = getArguments().getString("mealType","non");

        Log.d("IDK",mealType +" ");
      //  final HomeActivity activity = (HomeActivity) getActivity();

        myView = inflater.inflate(R.layout.activity_search, container, false);

        searchBar =(SearchView)myView.findViewById(R.id.search_bar);
        searchBar.setQueryHint("Search for food...");
        searchResult = (ListView)myView.findViewById(R.id.listview_search);
        scanButton =(ImageButton)myView.findViewById(R.id.scanner_button);
        customFood = (Button)myView.findViewById(R.id.create_food);

        customFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent customFoodIntent = new Intent(getActivity(),CustomFoodActivity.class);
                customFoodIntent.putExtra("id",_id);
                customFoodIntent.putExtra("mealType",mealType);

                startActivity(customFoodIntent);
            }
        });

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivityForResult(new Intent(getActivity(),ScanActivity.class),CONTACT_REQUEST);

            }

        });

        searchBar.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });

        searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (newText.length()>2)
                {
                    searchResult.setVisibility(myView.VISIBLE);
                    callAPIwithText caller = (callAPIwithText) new callAPIwithText().execute(newText);
                }
                else
                {
                    searchResult.setVisibility(myView.INVISIBLE);
                }

                return false;
            }
        });
    return myView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String barcode;
        if(requestCode==CONTACT_REQUEST)
        {
            if(resultCode==RESULT_OK)
            {
                barcode = data.getStringExtra("barCodeResult");
            }
            else
            {
                barcode="null";
            }
            if(resultCode==RESULT_CANCELED)
            {
                Toast.makeText(getContext(),"Could not find that",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
         barcode = "null";
        }
        if ((barcode=="null"))
        {
            Toast.makeText(getContext(),"Could not find that",Toast.LENGTH_LONG).show();
        }
        else
        {
            Log.d("lev3",barcode);

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            Api api = retrofit.create(Api.class);
            // Call<Example> call = api.getFood("https://api.edamam.com/api/food-database/parser?ingr=red%20apple&app_id=129fed80&app_key=bbd2848b3ab260bdc3d6e2776aca2f68");
            //Call<Example> call = api.getFood1("chicken","129fed80","bbd2848b3ab260bdc3d6e2776aca2f68");
            Call<BarcodeResult> call1 = api.getFoodBarcode(barcode,"129fed80","bbd2848b3ab260bdc3d6e2776aca2f68");

            call1.enqueue(new Callback<BarcodeResult>() {
                @Override
                public void onResponse(Call<BarcodeResult> call, Response<BarcodeResult> response) {
                    BarcodeResult barcodeResult = response.body();
                    if (barcodeResult!=null)
                    {

                        Log.d("barResponse","Total"+barcodeResult.getHints().get(0).getFood().getNutrients().getENERCKCAL());
                        FoodForSearchBar tempFood = new FoodForSearchBar();
                        tempFood.setFoodName(barcodeResult.getHints().get(0).getFood().getLabel());
                        tempFood.setBrandname(barcodeResult.getHints().get(0).getFood().getBrand());
                        tempFood.setCalories(barcodeResult.getHints().get(0).getFood().getNutrients().getENERCKCAL());
                        tempFood.setProtein(barcodeResult.getHints().get(0).getFood().getNutrients().getPROCNT());
                        tempFood.setFats(barcodeResult.getHints().get(0).getFood().getNutrients().getFAT());
                        tempFood.setCarbs(barcodeResult.getHints().get(0).getFood().getNutrients().getCHOCDF());


                        Intent goToCustomFood = new Intent(getContext(),CustomFoodActivity.class);
                        goToCustomFood.putExtra("foodName",tempFood.getFoodName());
                        goToCustomFood.putExtra("foodBrand",tempFood.getBrandname());
                        goToCustomFood.putExtra("foodCalorie",tempFood.getCalories());
                        goToCustomFood.putExtra("protein",tempFood.getProtein());
                        goToCustomFood.putExtra("carbs",tempFood.getCarbs());
                        goToCustomFood.putExtra("fats",tempFood.getFats());
                        Log.d("idinSearchCall",_id +" ");
                        goToCustomFood.putExtra("id",_id);
                        goToCustomFood.putExtra("mealType",mealType);
                        startActivity(goToCustomFood);


                    }
                    else
                    {
                        Log.d("noresponse","result null");
                    }
                }

                @Override
                public void onFailure(Call<BarcodeResult> call, Throwable t) {
                    Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });




        }


    }

    public ArrayList<FoodForSearchBar> filterFoodList(String toSearch)
    {
        String foodName;
        filteredFoodList.clear();
        Log.d("filter",allFoods.size()+" ");
        for(int i= 0; i<allFoods.size();i++)
        {
            foodName = allFoods.get(i).getFoodName().toLowerCase();
            Log.d("tosearch",toSearch.toLowerCase());
            Log.d("foodfromlist",allFoods.get(i).getFoodName().toLowerCase());
            Log.d("bool", "boolval: "+ foodName.contains(toSearch.toLowerCase()));
            if(foodName.contains(toSearch.toLowerCase()))
            {
                filteredFoodList.add(new FoodForSearchBar(allFoods.get(i).getFoodName(),allFoods.get(i).getBrandname(),allFoods.get(i).getCalories(),allFoods.get(i).getProtein(),allFoods.get(i).getCarbs(),allFoods.get(i).getFats()));
            }
            Log.d("sizeinfunction",filteredFoodList.size()+" ");
        }
        return filteredFoodList;
    }

    class callAPIwithText extends AsyncTask<String, Void, String>
    {
        String textToSearch;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setCancelable(false);
            progressDialog.setMessage("Searching...");
            progressDialog.getWindow().setGravity(Gravity.CENTER);
            progressDialog.show();



        }

        @Override
        protected String doInBackground(String... searchText) {
            Log.d("toSearch",searchText[0]);
            String returnResult = getAllFoods(searchText[0]);
            Log.d("fromGet",returnResult);
            this.textToSearch = searchText[0];

            return returnResult;
        }


        public String getAllFoods(String food)
        {
             final FoodForSearchBar tempFood = new FoodForSearchBar();

            try {


                Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl(BASE_URL)

                            .addConverterFactory(GsonConverterFactory.create())
                            .build();
                    Api api = retrofit.create(Api.class);
                    Call<Example> call = api.getFood1(food,"129fed80","bbd2848b3ab260bdc3d6e2776aca2f68");
                   // Call<BarcodeResult> call1 = api.getFoodBarcode("7874237003","129fed80","bbd2848b3ab260bdc3d6e2776aca2f68");
                            Log.d("lev1","I got here");
                    call.enqueue(new Callback<Example>() {
                        @Override
                        public void onResponse(Call<Example> call, Response<Example> response) {
                            Example searchResult = response.body();

                            Log.d("lev2","I got here");
                            int lengthofResponse = searchResult.getHints().size();

                            //Need to create dynamic search views
//                            Log.d("response",searchResult.getHints().get(0).getFood().getLabel());

                            for (int i = 0; i<lengthofResponse; i++)
                            {
                                tempFood.setFoodName(searchResult.getHints().get(i).getFood().getLabel());
                                tempFood.setCalories(searchResult.getHints().get(i).getFood().getNutrients().getENERCKCAL());
                                tempFood.setBrandname(searchResult.getHints().get(i).getFood().getBrand());
                                tempFood.setCarbs(searchResult.getHints().get(i).getFood().getNutrients().getCHOCDF());
                                tempFood.setProtein(searchResult.getHints().get(i).getFood().getNutrients().getPROCNT());
                                tempFood.setFats(searchResult.getHints().get(i).getFood().getNutrients().getFAT());
                               // foodList.add(searchResult.getHints().get(i).getFood().getLabel()+ "    "+ searchResult.getHints().get(i).getFood().getNutrients().getENERCKCAL());
                               String matchFound = "N";
                                for (int j=0;j<allFoods.size();j++)
                                {
                                    if(allFoods.get(j).getFoodName().equals(tempFood.getFoodName()))
                                    {
                                        matchFound ="Y";
                                    }
                                }
                                if (matchFound=="N")
                                {
                                    Log.d("match","got to the point to add food to list");
                                    allFoods.add(new FoodForSearchBar(tempFood.getFoodName(),tempFood.getBrandname(),tempFood.getCalories(),tempFood.getProtein(),tempFood.getCarbs(),tempFood.getFats()));
                                    Log.d("addedFOod",allFoods.size()+" ");
                                }
                            }
                            Log.d("size",allFoods.size()+" ");

                        }

                        @Override
                        public void onFailure(Call<Example> call, Throwable t) {
                            Toast.makeText(getActivity(),t.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    });


                return ("OK");

            }
            catch (Exception e)
            {
                e.printStackTrace();
                return ("Exception Caught");
            }

        }

        @Override
        protected void onPostExecute(String result)
        {
            super.onPostExecute(result);

            if (result.equalsIgnoreCase("Exception Caught"))
            {
                Toast.makeText(getActivity(),"Unable to Connect to the Server", Toast.LENGTH_LONG).show();
                progressDialog.dismiss();
            }
            else
            {
                Log.d("lev4","I got here");
                Log.d("allfoodlist",allFoods.size()+" ");
                ArrayList<FoodForSearchBar> NewList= filterFoodList(textToSearch);
                Log.d("lev5",textToSearch);
                Log.d("filteredSize",NewList.size() +" ");

                searchResult.setAdapter(new SearchResultAdapter(getActivity(),NewList,_id,mealType));
                progressDialog.dismiss();
            }
        }
    }
}

