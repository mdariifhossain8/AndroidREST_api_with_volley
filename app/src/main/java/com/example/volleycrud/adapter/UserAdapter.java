package com.example.volleycrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.bumptech.glide.Glide;
import com.example.volleycrud.R;
import com.example.volleycrud.model.UserInnforamtion;

import org.json.JSONArray;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

private Context context;
private List<UserInnforamtion> data;

public UserAdapter(Context context, List<UserInnforamtion> data) {
        this.context = context;
        this.data = data;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_view,null,false);
        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.textView.setText(data.get(i).getLogin());

        Glide.with(viewHolder.imageView.getContext()).load(data.get(i).getAvatarUrl()).into(viewHolder.imageView);

        }

@Override
public int getItemCount() {
        return data.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{

    ImageView imageView;
    TextView textView;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.image_view_id);
        textView = itemView.findViewById(R.id.text_view_id);
    }
}
}