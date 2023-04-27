
In this RelativeLayout, move TextView id="@+id/bancu_2" and TextView id="@+id/bancu_2" to be from the new line
<RelativeLayout
android:id="@+id/mRelativeLayout7"
android:layout_width="match_parent"
android:layout_height="50dp"
android:layout_below="@+id/mRelativeLayout6"
android:background="@drawable/shadow_bottom">

                    <TextView
                        android:id="@+id/bancu"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerVertical="true"
                        android:autoLink="email"
                        android:text="@string/programmer"
                        android:textColor="@android:color/black"
                        android:textStyle="bold" />

                    <TextView
                        android:id="@+id/bancu_1"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerVertical="true"
                        android:layout_marginStart="10dp"
                        android:layout_toEndOf="@+id/bancu"

                        android:text="@string/bancu_vitalie" />

                    <TextView
                        android:id="@+id/bancu_2"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerVertical="true"
                        android:layout_marginStart="20dp"
                        android:layout_toEndOf="@+id/bancu_1"
                        android:onClick="onCallTextivewClick"
                        android:textColor="#FF0000"
                        android:text="@string/_CALL_PHONE_BANCU"/>


                    <TextView
                        android:id="@+id/bancu_3"
                        android:layout_width="wrap_content"
                        android:layout_height="wrap_content"
                        android:layout_centerVertical="true"
                        android:layout_marginStart="20dp"
                        android:layout_toEndOf="@+id/bancu_2"
                        android:onClick="onCallTextivewClick"
                        android:textColor="#FF0000"
                        android:text="@string/_SEND_MAIL_BANCU"/>



                </RelativeLayout>