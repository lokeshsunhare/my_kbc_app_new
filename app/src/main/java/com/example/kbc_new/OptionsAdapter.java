package com.example.kbc_new;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OptionsAdapter extends RecyclerView.Adapter {

    List<Option> optionList;
    Context context;

    public OptionsAdapter(Context context, List<Option> optionList) {
        this.optionList = optionList;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.option_adater_item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ItemHolder) holder).radio_option.setText(optionList.get(position).getOption());
        ((ItemHolder) holder).radio_option.setChecked(optionList.get(position).isCheck());

        ((ItemHolder) holder).radio_option.setOnClickListener(view -> {
            for (int i = 0; i < optionList.size(); i++) {
                ((ItemHolder) holder).radio_option.setChecked(false);
                optionList.get(i).setCheck(false);
            }
            for (int i = 0; i < optionList.size(); i++) {
                if (!optionList.get(i).isCheck()) {
                    ((ItemHolder) holder).radio_option.setChecked(true);
                    optionList.get(position).setCheck(true);
                }
            }
            notifyDataSetChanged();

        });

    }

    @Override
    public int getItemCount() {
        return optionList.size();
    }

    public static class ItemHolder extends RecyclerView.ViewHolder {

        RadioButton radio_option;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);

            radio_option = itemView.findViewById(R.id.radio_option);
        }
    }
}
