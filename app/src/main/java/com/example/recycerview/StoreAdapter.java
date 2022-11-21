package com.example.recycerview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.StoreViewHolder> {


    private List<Store> storeList;
    private OnItemClickListener onItemClickListener;

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
        holder.bind(storeList.get(position));

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
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onClick(getAdapterPosition());
                    }

                    Log.d("BBB", "onClick: Position "+getAdapterPosition());
                }
            });

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
                            service +=store.getListServiceType().get(i).toString() +"/";
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

            // Time close
            Calendar calendar =Calendar.getInstance();
            int hourCurrent =calendar.get(Calendar.HOUR);
            int minutesCurrent =calendar.get(Calendar.MINUTE);

            int milliSecondCurrent = (minutesCurrent +hourCurrent*60)*60000;

            if (store.getOpenTime()>milliSecondCurrent || store.getCloseTime() <=milliSecondCurrent)
            {
                long minutes =MilliSecondToMinutes(store.getOpenTime());
                long hour =MilliSecondToHour(store.getOpenTime());
                tvClose.setText(String.format(" Đóng cửa \n Đặt bàn vào lúc \n %s:%s",prefixForTime(hour),prefixForTime(minutes)));
                tvClose.setVisibility(View.VISIBLE);

            }else
            {
                tvClose.setVisibility(View.GONE);

            }



        }


    }
    private String prefixForTime(long time) {
        return time < 10 ? "0" + time : String.valueOf(time);
    }
    public long MilliSecondToHour(long milliSeconds)
    {
        return milliSeconds/(60*60000);
    }
    public long MilliSecondToMinutes(long milliSeconds)
    {
        return milliSeconds%(60*60000)/60000;
    }

    public void setOnclickListener(OnItemClickListener onItemClickListener)
    {
        this.onItemClickListener = onItemClickListener;
    }
    interface OnItemClickListener{
        void onClick (int position);
    }

}
