package com.example.androidversionsass;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidversionsass.databinding.ItemAndroidVersionBinding;

import java.util.List;
import androidx.recyclerview.widget.RecyclerView;

public class AndroidVersionAdapter extends RecyclerView.Adapter<AndroidVersionAdapter.VersionViewHolder>{
    Context context;
    List<AndroidVersion> versionList;

    public AndroidVersionAdapter(Context context, List<AndroidVersion> versionList) {
        this.context = context;
        this.versionList = versionList;
    }

    @NonNull
    @Override
    public VersionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        ItemAndroidVersionBinding binding = ItemAndroidVersionBinding.inflate(inflater, parent, false);
        return new VersionViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VersionViewHolder holder, int position) {
        AndroidVersion version = versionList.get(position);


        holder.binding.imageViewLogo.setImageResource(version.imageResId);
        holder.binding.textViewCodeName.setText(version.codeName);
        holder.binding.textViewVersion.setText(version.version);


        holder.binding.getRoot().setOnClickListener(v -> {
            String message = "You selected: " + version.codeName + " (" + version.version + ")";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });


        if (position % 2 == 0) {
            holder.binding.getRoot().setBackgroundColor(0xFFE3F2FD);
        } else {
            holder.binding.getRoot().setBackgroundColor(0xFFFFFFFF);
        }
    }

    @Override
    public int getItemCount() {
        return versionList.size();
    }


    public static class VersionViewHolder extends RecyclerView.ViewHolder {
        ItemAndroidVersionBinding binding;

        public VersionViewHolder(@NonNull ItemAndroidVersionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
