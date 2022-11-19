package com.example.recycerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {

  // Yêu cầu truyền data vào để xác định được kích thước của Adapter trong ham getItemCount
    private List<Store> storeList;
    public StoreAdapter(List<Store> storeList)
    {
        this.storeList =storeList;
    }


    @NonNull
    @Override
    public StoreViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.layout_item_store, parent, false);


        return new StoreViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (storeList == null || storeList.size() ==0) {
            return 0;
        }
        return storeList.size();
    }

    class StoreViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView tvClose, tvName, tvDistance, tvSaleOff, tvAddress, tvServiceType;


        public StoreViewHolder(@NonNull View itemView) {
            super(itemView);
            img =itemView.findViewById(R.id.image_view_food);
            tvName =itemView.findViewById(R.id.text_view_name);
            tvAddress =itemView.findViewById(R.id.text_view_address);
            tvClose =itemView.findViewById(R.id.text_view_title_close_time);
            tvDistance =itemView.findViewById(R.id.text_view_distance);
            tvSaleOff =itemView.findViewById(R.id.text_view_sale_off);
            tvServiceType =itemView.findViewById(R.id.text_view_service_type);

        }
        public void bind(Store store)
        {
            img.setImageResource(store.getImage());
            tvName.setText(store.getName());
            tvAddress.setText(store.getAddress());

            // Service type
            if (store.getListServiceType().isEmpty())
            {
                tvServiceType.setVisibility(View.GONE);
            }
            else {
                String service ="";
                if (store.getListServiceType().size()==1)
                {
                    service +=store.getListServiceType().get(0).toString();
                } else {
                    for (int i = 0; i < store.getListServiceType().size();i++)
                    {
                        if (i == store.getListServiceType().size()-1)
                        {
                            service +=store.getListServiceType().get(i).toString();
                        } else
                        {
                            service +=store.getListServiceType().get(i).toString() +"/"
                        }
                    }

                }
                tvServiceType.setText(service);
                tvServiceType.setVisibility(View.VISIBLE);
            }
            // sale off
            if (store.getSaleOff().isEmpty())
            {
                tvSaleOff.setVisibility(View.GONE);
            }else
            {
                tvSaleOff.setText(store.getSaleOff());
                tvSaleOff.setVisibility(View.VISIBLE);
            }
            // Distance
            if (store.getDistance()==0)
            {
                tvDistance.setVisibility(View.GONE);
            }else
            {
                tvDistance.setText(">"+store.getDistance());
                tvSaleOff.setVisibility(View.VISIBLE);
            }

        }
    }

}
