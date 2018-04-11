package com.victormotogna.lilac.ui.orders;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.victormotogna.lilac.R;
import com.victormotogna.lilac.model.Order;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ItemViewHolder> {

    private Context context;
    private List<Order> orders;
    private OnItemClickListener onItemClickListener;

    public OrdersAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrdersAdapter.ItemViewHolder(LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_order, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        final Order order = orders.get(position);

        holder.description.setText(order.getDescription());
        holder.price.setText(order.getPrice() + " lei");
        holder.address.setText(order.getAddress());
        holder.client.setText(order.getClient());

        holder.learn_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClicked(position, order);
                }
            }
        });

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickListener != null) {
                    onItemClickListener.onItemClicked(position, order);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClicked(int position, Order order);
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        View root;
        TextView description;
        TextView price;
        TextView address;
        TextView client;
        Button learn_more;

        public ItemViewHolder(View itemView) {
            super(itemView);
            root = itemView;
            description = itemView.findViewById(R.id.description);
            price = itemView.findViewById(R.id.price);
            address = itemView.findViewById(R.id.address);
            client = itemView.findViewById(R.id.client);
            learn_more = itemView.findViewById(R.id.learn_more);
        }
    }
}
