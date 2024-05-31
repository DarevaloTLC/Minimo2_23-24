package edu.upc.dsa.kebabsimulator_android;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import edu.upc.dsa.kebabsimulator_android.models.API;
import edu.upc.dsa.kebabsimulator_android.models.Badge;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {

    private EditText editTextUserId;
    private Button buttonFetchBadges;
    private RecyclerView recyclerViewBadges;
    private BadgeAdapter badgeAdapter;
    private List<Badge> badgeList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        editTextUserId = findViewById(R.id.editTextUserId);
        buttonFetchBadges = findViewById(R.id.buttonFetchBadges);
        recyclerViewBadges = findViewById(R.id.recyclerViewBadges);

        badgeList = new ArrayList<>();
        badgeAdapter = new BadgeAdapter(badgeList);

        recyclerViewBadges.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewBadges.setAdapter(badgeAdapter);

        buttonFetchBadges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = editTextUserId.getText().toString();
                if (!userId.isEmpty()) {
                    fetchBadges(userId);
                } else {
                    Toast.makeText(ProfileActivity.this, "Please enter a User ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void fetchBadges(String userId) {
        API apiService = API.apiService;
        Call<List<Badge>> call = apiService.getUserBadges(userId);

        call.enqueue(new Callback<List<Badge>>() {
            @Override
            public void onResponse(Call<List<Badge>> call, Response<List<Badge>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    badgeList.clear();
                    badgeList.addAll(response.body());
                    badgeAdapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(ProfileActivity.this, "Error fetching badges", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Badge>> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, "Network error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
