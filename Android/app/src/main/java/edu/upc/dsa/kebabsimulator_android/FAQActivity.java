package edu.upc.dsa.kebabsimulator_android;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import edu.upc.dsa.kebabsimulator_android.models.API;
import edu.upc.dsa.kebabsimulator_android.models.FAQ;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class FAQActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FAQListAdapter adapter;
    private ProgressBar progressBar;
    private static final String TAG = FAQActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        recyclerView = findViewById(R.id.faqRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        adapter = new FAQListAdapter();
        recyclerView.setAdapter(adapter);
        fetchFaqs();
    }
    private void fetchFaqs() {
        API apiService = API.apiService;
        Call<List<FAQ>> call = apiService.getFAQs();
        call.enqueue(new Callback<List<FAQ>>() {
            @Override
            public void onResponse(Call<List<FAQ>> call, Response<List<FAQ>> response) {
                progressBar.setVisibility(View.INVISIBLE);
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setData(response.body());
                } else {
                    Log.w(TAG, "Respuesta no exitosa o cuerpo nulo, HTTP " + response.code());
                    Toast.makeText(FAQActivity.this, "Failed to retrieve data. HTTP code: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }
            @Override
            public void onFailure(Call<List<FAQ>> call, Throwable t) {
                progressBar.setVisibility(View.INVISIBLE);
                Log.e(TAG, "Error in Retrofit: " + t.toString());
                Toast.makeText(FAQActivity.this, "Network error: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
