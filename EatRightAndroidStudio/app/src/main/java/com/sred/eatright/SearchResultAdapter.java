package com.sred.eatright;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class SearchResultAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private ArrayList<FoodForSearchBar> foodDetail = new ArrayList<FoodForSearchBar>();
    int count;
    Context context;

    public SearchResultAdapter(Context context, ArrayList<FoodForSearchBar> foodDetails)
    {
        layoutInflater = LayoutInflater.from(context);
        this.foodDetail = foodDetails;
        this.count = foodDetails.size();
        this.context = context;
        Log.d("adapterList",foodDetails.size()+" ");

    }
    @Override
    public int getCount() {
        return count;
    }

    @Override
    public Object getItem(int position) {
        return foodDetail.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        FoodForSearchBar tempFood = foodDetail.get(position);


        if(convertView ==null)
        {
            convertView =layoutInflater.inflate(R.layout.search_result,null);
            holder = new ViewHolder();
            holder.food_name = (TextView) convertView.findViewById(R.id.food_name);
            holder.food_brand =(TextView) convertView.findViewById(R.id.product_bb);
            holder.food_bvalue = (TextView)convertView.findViewById(R.id.product_bbvalue);
            holder.food_calorie =(TextView) convertView.findViewById(R.id.food_calories);
            holder.food_calorie_value =(TextView) convertView.findViewById(R.id.food_calories_value);
            holder.add_food =(Button)convertView.findViewById(R.id.add_cart);
         convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder)convertView.getTag();
        }

        holder.food_name.setText(tempFood.getFoodName());

        holder.food_calorie_value.setText(String.valueOf(tempFood.getCalories()));
        holder.food_bvalue.setText(tempFood.getBrandname());


        return convertView;
    }


    static class ViewHolder
    {
        TextView food_name;
        TextView food_calorie;
        TextView food_calorie_value;
        TextView food_brand;
        TextView food_bvalue;
        Button add_food;

    }
}
