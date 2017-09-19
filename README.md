# PopMenu
PopMenu
用法：
  PopMenuManager.getInstance().init(MainActivity.this, new PopMenuManager.Builder()
                        .setFirstContent("相机")
                        .setSecendContent("相册")
                        .setThirdtContent("取消").build(), new PopMenuManager.OnViewClickListener() {
                    @Override
                    public void onMenuClick(int flag) {

                        switch (flag){
                            case PopMenuManager.MENU_FIRST:
                                toast.setText("1");
                                toast.show();
                                break;
                            case PopMenuManager.MENU_SECEND:
                                toast.setText("2");
                                toast.show();
                                break;
                            case PopMenuManager.MENU_THIRD:
                                toast.setText("3");
                                toast.show();
                                break;
                        }
                    }
                }).showOutMenu(rlroot);
