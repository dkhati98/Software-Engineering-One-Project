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
    String found = "N";
    static final int CONTACT_REQUEST =1;

    ArrayList<FoodForSearchBar> allFoods = new ArrayList<FoodForSearchBar>();
    ArrayList<FoodForSearchBar>filteredFoodList = new ArrayList<FoodForSearchBar>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        final HomeActivity activity = (HomeActivity) getActivity();

        myView = inflater.inflate(R.layout.activity_search, container, false);

        searchBar =(SearchView)myView.findViewById(R.id.search_bar);
        searchBar.setQueryHint("Search for food...");
        searchResult = (ListView)myView.findViewById(R.id.listview_search);
        scanButton =(ImageButton)myView.findViewById(R.id.scanner_button);

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
                if (newText.length()>3)
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

                        Intent goToCustomFood = new Intent(getContext(),CustomFoodActivity.class);
                        goToCustomFood.putExtra("foodName",tempFood.getFoodName());
                        goToCustomFood.putExtra("foodBrand",tempFood.getBrandname());
                        goToCustomFood.putExtra("foodCalorie",tempFood.getCalories());
                        goToCustomFood.putExtra("id",123);
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
                filteredFoodList.add(new FoodForSearchBar(allFoods.get(i).getFoodName(),allFoods.get(i).getBrandname(),allFoods.get(i).getCalories()));
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
                                    allFoods.add(new FoodForSearchBar(tempFood.getFoodName(),tempFood.getBrandname(),tempFood.getCalories()));
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

                searchResult.setAdapter(new SearchResultAdapter(getActivity(),NewList));
                progressDialog.dismiss();
            }
        }
    }
}



//
//public class Search extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//        final Button button_help = (Button) findViewById(R.id.button_help);
//        final Button button_home = (Button) findViewById(R.id.button_home);
//        final Button button_profile = (Button) findViewById(R.id.button_profile);
//
//        final ImageButton scan_button = (ImageButton) findViewById(R.id.scanner_button);
//        final View myView = (View) findViewById(R.id.search_view);
//        final SearchView searchButton = findViewById(R.id.search_bar);
//
//        final ListView searchResult = (ListView)findViewById(R.id.listview_search);
//
//
//
//        searchButton.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//
//            }
//        });
//
//        searchButton.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//
//                if(query.length()>3)
//                {
//                    searchResult.setVisibility(myView.VISIBLE);
//
//
//                    //function to search
//                }
//                else
//                {
//                    searchResult.setVisibility(myView.INVISIBLE);
//                }
//
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });
//
//        //search button is not going to work. We need search listeneer.
////        searchButton.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                String searchText = search_bar.getText().toString().trim();
////
////                if(searchText!=null)
////                {
////
////
////                    Retrofit retrofit = new Retrofit.Builder()
////                            .baseUrl(BASE_URL)
////
////                            .addConverterFactory(GsonConverterFactory.create())
////                            .build();
////                    Api api = retrofit.create(Api.class);
////                    Call<Example> call = api.getFood1(searchText,"129fed80","bbd2848b3ab260bdc3d6e2776aca2f68");
////                   // Call<BarcodeResult> call1 = api.getFoodBarcode("7874237003","129fed80","bbd2848b3ab260bdc3d6e2776aca2f68");
////
////                    call.enqueue(new Callback<Example>() {
////                        @Override
////                        public void onResponse(Call<Example> call, Response<Example> response) {
////                            Example searchResult = response.body();
////                            ArrayList<String> foodList = new ArrayList<>();
////
////                            int lengthofResponse = searchResult.getHints().size();
////
////                            //Need to create dynamic search views
////
////                            for (int i = 0; i<lengthofResponse; i++)
////                            {
////                                foodList.add(searchResult.getHints().get(i).getFood().getLabel()+ "    "+ searchResult.getHints().get(i).getFood().getNutrients().getENERCKCAL());
////
////                            }
////                            ArrayAdapter<String> stringAdapter = new ArrayAdapter<String>(Search.this,android.R.layout.simple_list_item_1,foodList);
////
////                            listView.setAdapter(stringAdapter);
////
////                            if (searchResult!=null)
////                            {
////                                String res = "number of results is "+ lengthofResponse;
////
////                                Toast.makeText(getApplicationContext(),res,Toast.LENGTH_LONG).show();
////
////
////                                android.util.Log.d("barResponse","Total"+searchResult.getHints().get(0).getFood().getNutrients().getENERCKCAL());
////
////                            }
////                            else
////                            {
////                                Log.d("noresponse","result null");
////                            }
////                        }
////
////                        @Override
////                        public void onFailure(Call<Example> call, Throwable t) {
////                            Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
////                        }
////                    });
////
////
////
////                }
////
////            }
////        });
//
//
//
//        //Insert code for search bar (EditText name search_bar)
//
//        //Insert code for scanner (Button name scanner)
//
//        //help button
//        button_help.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToHelp = new Intent(Search.this, Help.class);
//                startActivity(moveToHelp);
//            }
//        });
//
//        //create food button
//        create_food.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToCustomFood = new Intent(Search.this, customFood.class);
//                startActivity(moveToCustomFood);
//            }
//        });
//
//        //home screen button
//        button_home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToHome = new Intent(Search.this, Home.class);
//                startActivity(moveToHome);
//            }
//        });
//
//        //profile button
//        button_profile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent moveToProfile = new Intent(Search.this, ProfileActivity.class);
//                startActivity(moveToProfile);
//            }
//        });
//
//    }
//}
