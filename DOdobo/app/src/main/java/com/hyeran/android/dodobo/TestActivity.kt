package com.hyeran.android.dodobo

import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.util.Log
import com.google.android.gms.common.api.Status
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment
import com.google.android.gms.location.places.ui.PlaceSelectionListener
import com.google.android.gms.maps.MapView
import kotlinx.android.synthetic.main.activity_test.*
import com.google.android.gms.location.places.Place
import com.google.android.gms.location.places.ui.SupportPlaceAutocompleteFragment
import java.security.AccessController.getContext


class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        var autocompleteFragement : PlaceAutocompleteFragment = fragmentManager.findFragmentById(R.id.place_autocomplete_fragment) as PlaceAutocompleteFragment


            autocompleteFragement.setOnPlaceSelectedListener(object : PlaceSelectionListener {
            override fun onError(p0: Status?) {
                Log.v("login 실패", p0.toString())
            }

            override fun onPlaceSelected(place: Place) {
                    val location = Location("")
                    location.setLatitude(place.latLng.latitude)
                    location.setLongitude(place.latLng.longitude)
//                    setCurrentLocation(location, place.name.toString(), place.address.toString())
                }

//                fun onError(status: Status) {
//                    Log.i(FragmentActivity.TAG, "An error occurred: $status")
//                }
            })


    }
}
