package com.example.a1796138.recyclerviewexample;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.OneItemViewHolder> {
    ArrayList<User> userList;

    UserAdapter(ArrayList<User> list){
        userList = list;
    }

    @NonNull
    @Override
    public OneItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View inflatedView = inflater.inflate(R.layout.per_item_view, viewGroup, false);



        return new OneItemViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull OneItemViewHolder oneItemViewHolder, final int i) {
        oneItemViewHolder.tvQuestion.setText(userList.get(i).name);
        oneItemViewHolder.rbChoice1.setText(userList.get(i).address);
        oneItemViewHolder.rbChoice2.setText(userList.get(i).phone);

        oneItemViewHolder.rbChoice1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("RecycleView", "Radio Button1 Clicked");
            }
        });
        oneItemViewHolder.rbChoice2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("RecycleView", "Radio Button2 Clicked");
            }
        });
        oneItemViewHolder.rbChoice3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("RecycleView", "Radio Button3 Clicked");
            }
        });
        oneItemViewHolder.rbChoice4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.i("RecycleView", "Radio Button4 Clicked");
            }
        });


        oneItemViewHolder.singleItemParentLayout.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.d("RecycleView", "Clicked card number: " + Integer.toString(i));
            }
        });


    }

    @Override
    public int getItemCount() {
        return  userList.size();
    }

    class OneItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvQuestion;
        RadioGroup rgChoices;
        RadioButton rbChoice1, rbChoice2, rbChoice3, rbChoice4;
        RelativeLayout singleItemParentLayout;


        public OneItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvQuestion = itemView.findViewById(R.id.tvQuestion);
            rgChoices = itemView.findViewById(R.id.rgChoices);
            rbChoice1 = itemView.findViewById(R.id.rbChoice1);
            rbChoice2 = itemView.findViewById(R.id.rbChoice2);
            rbChoice3 = itemView.findViewById(R.id.rbChoice3);
            rbChoice4 = itemView.findViewById(R.id.rbChoice4);

            singleItemParentLayout = itemView.findViewById(R.id.single_item_parent_layout);

        }

    }
}
