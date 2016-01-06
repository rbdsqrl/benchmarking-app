package com.myapp.narendran.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Narendran on 02-12-2015.
 */
public class BenchMarkingActivity extends Activity{
    private EditText etArraySize;
    private RadioGroup radioGroup;
    private TextView tvGenMsg;
    private Button btnBubble;
    private Button btnInsertion;
    private Button btnSelection;
    private Button btnBenchmark;
    private TextView tvStatusBubble;
    private TextView tvStatusInsert;
    private TextView tvStatusSelect;
    private static int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_bench_mark);
        etArraySize = (EditText) findViewById(R.id.etArraySize);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        tvGenMsg = (TextView) findViewById(R.id.tvGenMsg);
        btnBubble = (Button) findViewById(R.id.btnBubble);
        btnInsertion = (Button) findViewById(R.id.btnInsertion);
        btnSelection = (Button) findViewById(R.id.btnSelection);
        btnBenchmark = (Button) findViewById(R.id.btnBenchmark);
        tvStatusBubble = (TextView) findViewById(R.id.tvStatusBubble);
        tvStatusInsert = (TextView) findViewById(R.id.tvStatusInsert);
        tvStatusSelect = (TextView) findViewById(R.id.tvStatusSelect);
    }

    public void GenerateArray(View view){

        if(TextUtils.isEmpty(etArraySize.getText().toString())==true){
            Toast toast1 = Toast.makeText(this,"Enter Size please!", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
            toast1.show();
            tvGenMsg.setText("No array generated!");
            return;
        }
        tvGenMsg.setText("Your array is generated!");
        switch (radioGroup.getCheckedRadioButtonId()){

            case R.id.rbAveCase:
                array = ArrayMath.AverageCase(Integer.parseInt(etArraySize.getText().toString()));
                break;
            case R.id.rbBestCase:
                array = ArrayMath.BestCase(Integer.parseInt(etArraySize.getText().toString()));
                break;
            case R.id.rbWorstCase:
                array = ArrayMath.WorstCase(Integer.parseInt(etArraySize.getText().toString()));
                break;
        }



        Toast toast = Toast.makeText(this,"Array Generated", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
        toast.show();

    }

    public void BenchMarker(View view){
        if(TextUtils.isEmpty(etArraySize.getText().toString())==true){
            Toast toast1 = Toast.makeText(this,"Array Generated", Toast.LENGTH_SHORT);
            toast1.setGravity(Gravity.CENTER_HORIZONTAL,0,0);
            toast1.show();
            return;
        }
        int a[] = new int[array.length];
        a = ArrayMath.clone(array);
    switch(view.getId()){
        case R.id.btnBubble:
            long startBubble = System.currentTimeMillis();
            ArrayMath.BubbleSort(ArrayMath.clone(array));
            long endBubble = System.currentTimeMillis();
            tvStatusBubble.setText(""+(endBubble-startBubble)+"ms");
            break;
        case R.id.btnInsertion:
            long startIns = System.currentTimeMillis();
            ArrayMath.InsertionSort((ArrayMath.clone(array)));
            long endIns = System.currentTimeMillis();
            tvStatusInsert.setText(""+(endIns-startIns)+"ms");
            break;
        case R.id.btnSelection:
            long startSel = System.currentTimeMillis();
            ArrayMath.SelectionSort(ArrayMath.clone(array));
            long endSel = System.currentTimeMillis();
            tvStatusSelect.setText(""+(endSel-startSel)+"ms");
            break;
        case R.id.btnBenchmark:
            startBubble = System.currentTimeMillis();
            ArrayMath.BubbleSort(ArrayMath.clone(array));
            endBubble = System.currentTimeMillis();
            tvStatusBubble.setText("" + (endBubble - startBubble) + "ms");
            startIns = System.currentTimeMillis();
            ArrayMath.InsertionSort(ArrayMath.clone(array));
            endIns = System.currentTimeMillis();
            tvStatusInsert.setText("" + (endIns - startIns) + "ms");
            startSel = System.currentTimeMillis();
            ArrayMath.SelectionSort(ArrayMath.clone(array));
            endSel = System.currentTimeMillis();
            tvStatusSelect.setText(""+(endSel-startSel)+"ms");
            break;
    }
    }

}
