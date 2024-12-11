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

import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import ch.walica.temp41224_4tp1_jsonobj.model.Address;
import ch.walica.temp41224_4tp1_jsonobj.model.Person;


public class ObjectFragment extends Fragment {


    String json = "{\n" +
            "  \"firstName\": \"Jan\",\n" +
            "  \"age\": 23,\n" +
            "  \"address\": {\n" +
            "    \"country\": \"Polska\",\n" +
            "    \"city\": \"Cieszyn\"\n" +
            "  }\n" +
            "}";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_object, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnShowObject = view.findViewById(R.id.btnShowObj);
        Gson gson = new Gson();

        btnShowObject.setOnClickListener(v -> {

//            try {
//                JSONObject jsonObject = new JSONObject(Objects.requireNonNull(Util.loadJSONFromAssets("person.json", requireActivity())));
//                String name = jsonObject.getString("firstName");
//                int age = jsonObject.getInt("age");
//                JSONObject address = jsonObject.getJSONObject("address");
//                String country = address.getString("country");
//                String city = address.getString("city");
//                Person person = new Person(name, age, new Address(country, city));
//                Log.d(Util.TAG, "person: " + person);
//            } catch(JSONException e) {
//                Log.d(Util.TAG, "error: " + e.getLocalizedMessage());
//            }
            Person person = gson.fromJson(Util.loadJSONFromAssets("person.json", requireActivity()), Person.class);
            Log.d(Util.TAG, "person: " + person);
        });
    }
}