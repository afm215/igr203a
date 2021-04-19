package com.example.carte.ui;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.carte.R;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<ItemData> itemArrayList;
    private Context context;
    private int onMenu = 0;

    public CustomAdapter(ArrayList<ItemData> itemArrayList_,Context context, int onMenu) {
        this.itemArrayList = itemArrayList_;
        this.context = context;
        this.onMenu = onMenu;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view;
        if (onMenu==1){
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout_menu, parent, false);
        }
        else{
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_layout_carte, parent, false);
        }


        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ItemData itemData = itemArrayList.get(position);
        holder.textView.setText(itemData.getTitle());
        holder.imageView.setImageResource(itemData.getImageId());
    }

    @Override
    public int getItemCount() {
        return itemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private ImageView imageView;
        private ImageView minus;
        private ImageView plus;
        private TextView amount;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
            imageView = itemView.findViewById(R.id.imageView);

            ImageButton infoIcon = itemView.findViewById(R.id.info_icon);

            if (onMenu==0){
                amount = itemView.findViewById(R.id.amount);
                minus = itemView.findViewById(R.id.imageView3);
                plus = itemView.findViewById(R.id.imageView2);

                minus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("Waaaaaarining");
                        System.out.println(amount.getText().toString());
                        int quantity = Integer.parseInt(amount.getText().toString());
                        if (quantity >0){
                            quantity --;
                            amount.setText(Integer.toString(quantity));
                        }
                    }
                });

                plus.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        amount.setText(Integer.toString(Integer.parseInt(amount.getText().toString()) + 1));
                    }
                });
            }



            infoIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    LayoutInflater inflater = (LayoutInflater)
                            context.getSystemService(LAYOUT_INFLATER_SERVICE);
                    View popupView = inflater.inflate(R.layout.popup_window, null);

                    TextView textPopup = popupView.findViewById(R.id.textePopup);
                    ImageView imagePopup = popupView.findViewById(R.id.imagePopup);

                    textPopup.setText(textView.getText());
                    imagePopup.setImageDrawable(imageView.getDrawable());
                    // inflate the layout of the popup window

                    // create the popup window
                    int width = LinearLayout.LayoutParams.WRAP_CONTENT;
                    int height = LinearLayout.LayoutParams.WRAP_CONTENT;
                    boolean focusable = true; // lets taps outside the popup also dismiss it
                    final PopupWindow popupWindow = new PopupWindow(popupView, width, height, focusable);

                    // show the popup window
                    // which view you pass in doesn't matter, it is only used for the window tolken
                    popupWindow.showAtLocation(v, Gravity.CENTER, 0, 0);

                    ImageButton cancelButton = popupView.findViewById(R.id.quitPopUp);
                    cancelButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            popupWindow.dismiss();
                        }
                    });
                    Button recommendation = popupView.findViewById(R.id.recommendations);
                    Button menusAssocies = popupView.findViewById(R.id.menusAssocies);
                    recommendation.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Initializing the popup menu and giving the reference as current context
                            PopupMenu popupMenu = new PopupMenu(context, recommendation);

                            // Inflating popup menu from popup_menu.xml file
                            popupMenu.getMenuInflater().inflate(R.menu.popup_recommandation, popupMenu.getMenu());
                            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    // Toast message on menu item clicked
                                    Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                    return true;
                                }
                            });
                            // Showing the popup menu
                            popupMenu.show();
                        }
                    });
                    menusAssocies.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            // Initializing the popup menu and giving the reference as current context
                            PopupMenu popupMenu = new PopupMenu(context, menusAssocies);

                            // Inflating popup menu from popup_menu.xml file
                            popupMenu.getMenuInflater().inflate(R.menu.popup_menus, popupMenu.getMenu());
                            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                                @Override
                                public boolean onMenuItemClick(MenuItem menuItem) {
                                    // Toast message on menu item clicked
                                    Toast.makeText(context, menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                                    return true;
                                }
                            });
                            // Showing the popup menu
                            popupMenu.show();
                        }
                    });

                }
            });
        }
    }
}
