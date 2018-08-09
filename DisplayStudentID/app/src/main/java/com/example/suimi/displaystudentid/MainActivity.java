package com.example.suimi.displaystudentid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;
public class MainActivity extends AppCompatActivity {

    TextView tvPickedStudent;
    TextView tvStudentList;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        final String studentIds[] = {"12341", "12342", "12343", "12344", "12345", "12346", "12347", "12348", "12349", "12350",
                                "12351", "12352", "12353", "12354", "12355", "12356", "12357", "12358", "12359", "12360",
                                "12361", "12362", "12363", "12364", "12365", "12366", "12367", "12368", "12369", "12370",
                                "12371", "12372", "12373", "12374", "12375", "12376", "12377", "12378", "12379", "12380",
                                "12381", "12382", "12383", "12384", "12385", "12386", "12387", "12388", "12389", "12390"
                                };

        Random rand = new Random();

        int  n = rand.nextInt(studentIds.length);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStudentList = findViewById(R.id.tvStudentList);
                tvStudentList.setText("Student List\n");
                for(String sId : studentIds){
                    tvStudentList.append(sId + "\n");
                }
            }
        });


        tvPickedStudent = findViewById(R.id.tvPickedStudentId);
        tvPickedStudent.setText("Picked Student Id : " + studentIds[n] + "");
    }
}
