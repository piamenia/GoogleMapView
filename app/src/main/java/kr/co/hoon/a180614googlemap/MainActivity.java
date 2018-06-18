package kr.co.hoon.a180614googlemap;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback{
    // 맵을 출력할 수 있는 영역을 인스턴스변수로 선언
    private MapFragment map;

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // 맵의 중앙을 표시할 위도 경도 객체
        LatLng seoul = new LatLng(37.56, 126.97);
        // 마커 출력
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(seoul);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        googleMap.addMarker(markerOptions);
        // 맵의 위치 이동
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(seoul));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 맵을 출력할 수 있는 객체를 가져와서 출력할 수 있도록 Callback 객체 설정
        FragmentManager fragmentManager = getFragmentManager();
        MapFragment mapFragment = (MapFragment)fragmentManager.findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
}
