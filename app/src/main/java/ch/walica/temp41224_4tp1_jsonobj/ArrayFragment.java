package ch.walica.temp41224_4tp1_jsonobj;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import ch.walica.temp41224_4tp1_jsonobj.model.Address;
import ch.walica.temp41224_4tp1_jsonobj.model.Person;


public class ArrayFragment extends Fragment {

    List<Person> persons = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_array, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnShowArray = view.findViewById(R.id.btnShowArray);

        btnShowArray.setOnClickListener(v -> {

            try {
                JSONArray jsonArray = new JSONArray(Util.loadJSONFromAssets("persons.json", requireActivity()));

                for(int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String name = jsonObject.getString("firstName");
                    int age = jsonObject.getInt("age");
                    JSONObject address = jsonObject.getJSONObject("address");
                    String country = address.getString("country");
                    String city = address.getString("city");
                    Person person = new Person(name, age, new Address(country, city));

                    persons.add(person);
                }
                Log.d(Util.TAG, "persons: " + persons);

            } catch (JSONException e) {
                Log.d(Util.TAG, "error: " + e.getLocalizedMessage());
            }

        });
    }
}