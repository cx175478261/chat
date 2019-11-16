package com.example.chat;
/*
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
*/


/*
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
    }
    public void myclick(View v){
        switch (v.getId ()){
            case R.id.btn_1:
                showNormalDialog1();
                break;
            case  R.id.btn_2:
                showNormalDialog2();
                break;
            case R.id.btn_3:
                showListDialog();
                break;
            case R.id.btn_4:
                showSingleDialog();
                break;
            case R.id.btn_5:
                showMultiDialog();
                break;
            case R.id.btn_6:
                showWaitDialog();
                break;
            case R.id.btn_7:
                showProgressDialog();
                break;
        }
    }


    //AlertDialog的构造方法为protected，因此外包是无法使用的，所以我们要借助构建器Builder
    private void showNormalDialog1() {
        AlertDialog.Builder dialog = new AlertDialog.Builder (this);
        dialog.setTitle ("温馨提示").setMessage ("你确定要退出此程序嘛？");
        //点击确定就退出程序
        dialog.setPositiveButton ("确定", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.finish ();
            }
        });
        //如果取消，就什么都不做，关闭对话框
        dialog.setNegativeButton ("取消",null);
        dialog.show ();
    }
    private void showNormalDialog2(){
        AlertDialog dialog2 = new AlertDialog.Builder (this).create ();
        dialog2.setTitle ("坪价");
        dialog2.setMessage ("请为本次的服务打分!");
        dialog2.setButton (DialogInterface.BUTTON_POSITIVE, "5分", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText (MainActivity.this,"5分",Toast.LENGTH_LONG).show ();
            }
        });
        dialog2.setButton (DialogInterface.BUTTON_NEGATIVE, "3分", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText (MainActivity.this,"3分",Toast.LENGTH_LONG).show ();
            }
        });
        //一定要调用show（）方法，否则对话框不会显示
        dialog2.show ();
    }
    private void showListDialog(){
        final String[] items = {"小王","小李" ,"小白"};
        AlertDialog.Builder dialog3 = new AlertDialog.Builder (this).setTitle ("你是谁?")
                .setItems (items, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //如果点击小王的话那么which保存的就是0
                        Toast.makeText (MainActivity.this,"我是："+items[which],Toast.LENGTH_LONG).show ();
                    }
                });
        dialog3.show ();
    }

    int ide = 0;  //全局变量
    private void showSingleDialog() {
        final String[] stars = {"Jay","JJ" ,"Eson"};
        final AlertDialog.Builder dialog4 = new AlertDialog.Builder (this)
                .setTitle ("选择你喜欢的明星:")
                //参数1：选项。参数2：默认选项。参数3：选中时的事件
                .setSingleChoiceItems (stars, 0, new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Toast.makeText (MainActivity.this,"你选择了："+stars[which],Toast.LENGTH_LONG).show ();
                        ide = which;
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText (MainActivity.this,"你选择了："+stars[ide],Toast.LENGTH_LONG).show ();
                    }
                });   //点击确定后对话框消失，并且打印所选内容

        dialog4.show ();
    }

    private void showMultiDialog() {
        AlertDialog.Builder dialog5 = new AlertDialog.Builder (this);
        final String[] movie = {"复联1","复联2","复联3","复联4"};
        final boolean[] check = {true,false,true,false};
        dialog5.setTitle ("你想看什么电影？")
                //第一个参数是选项，第二个参数是默认备选项（true的是选中的），第三个参数是点击时触发的效果
                .setMultiChoiceItems (movie, check, new DialogInterface.OnMultiChoiceClickListener () {
                    @Override
                    //第一个参数对话框本身，第二个参数是按钮的索引，第三个是标志按钮是否处于选中状态true
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        Log.e("Log",movie[which]);
                    }
                }).setPositiveButton ("确定", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String msg = "你喜欢的电影是：";
                for (int n=0;n<check.length;n++){
                    if(check[n]){
                        msg = msg + movie[n] + " ";
                        Toast.makeText (MainActivity.this,msg,Toast.LENGTH_LONG).show ();
                    }
                }
            }
        });
        dialog5.show ();
    }

    private void showWaitDialog() {
        //进度条对话框，默认是转圈
        ProgressDialog progressDialog = new ProgressDialog (this);
        progressDialog.setTitle ("下载中....");       //设置标题
        progressDialog.setMessage ("请等待");
        progressDialog.show ();
    }

    private void showProgressDialog() {
        final ProgressDialog dialog7 = new ProgressDialog (this);
        dialog7.setTitle ("下载中....");       //设置标题
        dialog7.setMessage ("请等待");
        dialog7.setProgressStyle (ProgressDialog.STYLE_HORIZONTAL);   // 设置进度条的风格（水平）
        dialog7.setIndeterminate (false);   //设置进度条模糊(默认为True)
        dialog7.show ();
        //设置进度条的动态效果，需要创建一个线程
        final Thread thread = new Thread () {
            public void run(){
                super.run ();
                //让进度条从1走到100
                for (int i = 0;i<=100;i++){
                    dialog7.setProgress (i);
                    try {           //抛出异常
                        Thread.sleep (50);          //每走动一下休眠50毫秒
                    } catch (InterruptedException e) {
                        e.printStackTrace ();
                    }
                }
                dialog7.dismiss ();   //当进度条到达100后，对话框消失
            }
        };
        thread.start ();      //启动线程
    }



}*/


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etAccount;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView(); //初始化布局
    }

    private void initView() {
        etAccount = (EditText) findViewById(R.id.etAccount);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        //获取用户输入的账号,密码的数据
        String account = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        //如果账号是123且密码是123,就登录成功
        if (account.equals("abc") && password.equals("123")){
           // Intent intent = new Intent(MainActivity.this,MainActivity.class);
            //startActivity(intent);
            //finish();
            Toast.makeText(MainActivity.this,"输入正确",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this,"账号或密码是无效的",Toast.LENGTH_SHORT).show();
        }
    }
}