package com.example.fang.dialogtest;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_no;
    private Button btn_easy;
    private Button btn_list;
    private Button btn_sex;
    private Button btn_love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_no = (Button) findViewById(R.id.btn_no);
        btn_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialog();
            }
        });
        btn_easy= (Button) findViewById(R.id.btn_easy);
        btn_easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialog2();
            }
        });
        btn_list= (Button) findViewById(R.id.btn_list);
        btn_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialogList();
            }
        });
        btn_sex= (Button) findViewById(R.id.btn_sex);
        btn_sex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSex();
            }
        });
        btn_love= (Button) findViewById(R.id.btn_love);
        btn_love.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initLove();
            }
        });

    }

    private void initLove() {
        final String item[]={"篮球","足球","跳舞"};
        final boolean select[]={true,false,false};

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("选择你喜欢的运动");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMultiChoiceItems(item, select, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                ToastUtil.showToast(MainActivity.this,item[which]+isChecked);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.showToast(MainActivity.this,"你点击了确定"+item[which]);
            }
        });
    }

    private void initSex() {
        final String item[]={"男","女"};
        final AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("选择你的性别：");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setSingleChoiceItems(item, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    ToastUtil.showToast(MainActivity.this,"你选择了"+item[which]);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ToastUtil.showToast(MainActivity.this,"你点击了确定"+which);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ToastUtil.showToast(MainActivity.this,"你点击了取消"+which);
            }
        });
        builder.create().show();

    }

    private void initDialogList() {
        final String items[]={"张越","方坤镇","老张"};
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("请选择一个角色");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.showToast(MainActivity.this,"你点击了"+items[which]);
            }
        });
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.showToast(MainActivity.this,"你点击了确定"+which);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ToastUtil.showToast(MainActivity.this,"你点击了取消"+which);
            }
        });
        builder.create().show();
    }

    private void initDialog2() {
        DialogInterface.OnClickListener di=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case Dialog.BUTTON_POSITIVE:
                        ToastUtil.showToast(MainActivity.this,"你点击了确定"+which);
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        ToastUtil.showToast(MainActivity.this,"你点击了取消"+which);
                        break;
                    case Dialog.BUTTON_NEUTRAL:
                        ToastUtil.showToast(MainActivity.this,"你点击了忽略"+which);
                }
            }
        };
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("确认取消吗》？");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setPositiveButton("确定",di);
        builder.setNegativeButton("取消",di);
        builder.setNeutralButton("忽略",di);
        builder.create().show();
    }

    private void initDialog() {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setTitle("提示");
        b.setMessage("确认取消吗？？");
        b.setIcon(R.mipmap.ic_launcher);
        b.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ToastUtil.showToast(MainActivity.this,"你点击了确定"+which);
            }
        });
        b.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ToastUtil.showToast(MainActivity.this,"你点击了取消"+which);
            }
        });
        b.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ToastUtil.showToast(MainActivity.this,"你点击了忽略"+which);
            }
        });
        b.create().show();
    }
}
