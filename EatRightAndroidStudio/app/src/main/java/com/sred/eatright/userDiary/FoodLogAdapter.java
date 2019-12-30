package com.sred.eatright.userDiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sred.eatright.R;

import java.util.List;

public class FoodLogAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Food> realmFoodList;
    Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public FoodLogAdapter(List<Food> realmFoodList, Context context) {
        this.realmFoodList = realmFoodList;
        this.context = context;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.row_food_log, parent, false);
        return new ViewHolderMyLife(v);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        ((ViewHolderMyLife) holder).title.setText(realmFoodList.get(position).getName());
        ((ViewHolderMyLife) holder).calories.setText(realmFoodList.get(position).getCalories() + "");
        ((ViewHolderMyLife) holder).carbs.setText(realmFoodList.get(position).getCarbs() + "");
        ((ViewHolderMyLife) holder).protein.setText(realmFoodList.get(position).getProtein() + "");

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return realmFoodList.size();
    }

    class ViewHolderMyLife extends RecyclerView.ViewHolder {
        TextView title, calories, protein, carbs, fat;
        LinearLayout ll_food, ll_food_detail;

        public ViewHolderMyLife(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_food_name);
            calories = itemView.findViewById(R.id.tv_food_calories);
            protein = itemView.findViewById(R.id.tv_food_protein);
            carbs = itemView.findViewById(R.id.tv_food_carbs);
            fat = itemView.findViewById(R.id.tv_food_fat);
            ll_food = itemView.findViewById(R.id.ll_food);
            ll_food_detail = itemView.findViewById(R.id.ll_food_detail);
        }

    }

}