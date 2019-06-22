package com.loader.pro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.loader.loader3.MFileLoader;
import com.loader.pro.R;
import com.loader.pro.databinding.ItemProfileBinding;
import com.loader.pro.model.ProfileResponse;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder> {

    private List<ProfileResponse.Profile> list;
    MFileLoader imageLoader;

    public ProfileAdapter( List<ProfileResponse.Profile> liveDealsList) {
        this.list = liveDealsList;
        imageLoader = MFileLoader.getInstance();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_profile, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(list.get(position));

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemProfileBinding binding;
        public ViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
        public void bind(ProfileResponse.Profile response){
            binding.setProfile(response);
        }

    }
}