package com.example.recycleviewexample;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<String> mData;
    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtItem;
        private Button btn_remove;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
            btn_remove = itemView.findViewById(R.id.btnRemove);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(itemView.getContext(),"你點擊的是項目不是按鈕",Toast.LENGTH_SHORT).show();
                }
            });
            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(itemView.getContext());
                    builder.setTitle("訊息")
                            .setMessage("確定要刪除?")
                            .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                                //設定確定按鈕
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Toast.makeText(itemView.getContext(),"刪除了!",Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                //設定取消按鈕
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                        dialogInterface.dismiss();
                                }
                            }).create().show();

                }
            });

        }
    }
    public MyAdapter(List<String> data) {
        mData = data;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int position) {
        holder.txtItem.setText(mData.get(position));

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
