package com.example.activitydemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.activitydemo.util.CustomDialog;
import com.example.activitydemo.util.ScreenSizeUtils;

import java.util.Timer;
import java.util.TimerTask;

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        Button btn3 = findViewById(R.id.btn3);

        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testAlertDialog();
            }
        });
        Button btn4 = findViewById(R.id.btn4);

        btn4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testAlertDialog2();
            }
        });
        Button btn5 = findViewById(R.id.btn5);

        btn5.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testAlertDialog3();
            }
        });
        Button btn6 = findViewById(R.id.btn6);

        btn6.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testAlertDialog4();
            }
        });
        Button btn7 = findViewById(R.id.btn7);

        btn7.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testAlertDialog5();
            }
        });
        //??????????????????
        Button btn8 = findViewById(R.id.btn8);

        btn8.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                testAlertDialog6();
            }
        });

        //??????????????????
        Button btn81 = findViewById(R.id.btn81);

        btn81.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final CustomDialog dialog = new CustomDialog(DialogActivity.this);
                dialog.setAll("????????????????????????","??????","??????","??????");
                dialog.setOnClickBottomListener(new CustomDialog.OnClickBottomListener() {
                    @Override
                    public void onPositiveClick() {
                        dialog.dismiss();
                    }
                    @Override
                    public void onNegtiveClick() {
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });

        //????????????????????????
        Button btn9 = findViewById(R.id.btn9);

        btn9.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ProgressDialog dialog = new ProgressDialog(DialogActivity.this);
                dialog.setMessage("???????????????");
                dialog.show();
            }
        });

        //???????????????????????????????????????
        Button btn10 = findViewById(R.id.btn10);

        btn10.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final ProgressDialog dialog = new ProgressDialog(DialogActivity.this);
                dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                dialog.setMessage("???????????????");
                dialog.setMax(100);
                final Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    int progress = 0;

                    @Override
                    public void run() {
                        dialog.setProgress(progress += 5);
                        if (progress == 100) {
                            timer.cancel();
                        }
                    }
                }, 0, 1000);
                dialog.show();
            }
        });
    }

    private void testAlertDialog() {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)//?????????????????????
                .setTitle("???????????????")//????????????????????????
                .setMessage("????????????????????????")//????????????????????????
                //????????????????????????
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "?????????????????????", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, "????????????????????????", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();

    }

    private void testAlertDialog2() {
        final String items[] = {"??????Item???", "??????Item???", "??????Item???", "??????Item???"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)//?????????????????????
                .setTitle("???????????????")//????????????????????????
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private void testAlertDialog3() {
        final String items[] = {"??????Item???", "??????Item???", "??????Item???", "??????Item???"};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)//?????????????????????
                .setTitle("?????????????????????")//????????????????????????
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(DialogActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }

    private void testAlertDialog4() {
        final String items[] = {"??????Item???", "??????Item???", "??????Item???", "??????Item???"};
        final boolean checkedItems[] = {true, false, true, false};
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)//?????????????????????
                .setTitle("???????????????")//????????????????????????
                .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        checkedItems[which] = isChecked;
                    }
                })
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedItems.length; i++) {
                            if (checkedItems[i]) {
                                Toast.makeText(DialogActivity.this, "?????????" + i, Toast.LENGTH_SHORT).show();
                            }
                        }
                        dialog.dismiss();
                    }

                }).create();

        dialog.show();

    }

    //?????????????????????
    private void testAlertDialog5() {
        View view = getLayoutInflater().inflate(R.layout.half_dialog_view, null);
        final EditText editText = view.findViewById(R.id.dialog_edit);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)//?????????????????????
                .setTitle("?????????????????????")//????????????????????????
                .setView(view)
                .setNegativeButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setPositiveButton("??????", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String content = editText.getText().toString();
                        Toast.makeText(DialogActivity.this, content, Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }).create();
        dialog.show();
    }


    private void testAlertDialog6() {
        Dialog dialog = new Dialog(this, R.style.NormalDialogStyle);
        View view = View.inflate(this, R.layout.dialog_bottom, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight() * 0.23f));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth() * 0.9f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);
        dialog.show();
    }

    //????????????????????????????????????
    @Override
    public void onBackPressed() {
        //????????????
        final AlertDialog dialog;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("???????????????");
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("??????????????????");
        //??????????????????
        builder.setPositiveButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();   //???????????????
                DialogActivity.this.finish(); //??????Activity
            }
        });
        //??????????????????
        builder.setNegativeButton("??????", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialog = builder.create();
        dialog.show();
    }

    /**
     * ??????????????????
     */
//    private void customDialog() {
//        final Dialog dialog = new Dialog(this, R.style.NormalDialogStyle);
//        View view = View.inflate(this, R.layout.dialog_normal, null);
//        TextView cancel = (TextView) view.findViewById(R.id.cancel);
//        TextView confirm = (TextView) view.findViewById(R.id.confirm);
//        dialog.setContentView(view);
//        //?????????????????????????????????????????????
//        dialog.setCanceledOnTouchOutside(true);
//        //????????????????????????
//        view.setMinimumHeight((int) (ScreenSizeUtils.getInstance(this).getScreenHeight() * 0.23f));
//        Window dialogWindow = dialog.getWindow();
//        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
//        lp.width = (int) (ScreenSizeUtils.getInstance(this).getScreenWidth() * 0.75f);
//        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
//        lp.gravity = Gravity.CENTER;
//        dialogWindow.setAttributes(lp);
//        cancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        confirm.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//        dialog.show();
//    }


}