package com.example.baidumap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.baidu.mapapi.map.InfoWindow
import com.baidu.mapapi.map.MapStatus
import com.baidu.mapapi.map.MapStatusUpdateFactory
import com.baidu.mapapi.model.LatLng
import com.example.baidumap.track.activity.BaseActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : BaseActivity() {
    override fun getContentViewId(): Int {
        return R.layout.activity_main2
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main2)
        //缩放
        val builder = MapStatus.Builder()
        builder.zoom(15.0f)
        bmapview.map.setMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()))
        //以谁为中心
        val LOCATION = LatLng(34.721304, 113.747491)
        val status = MapStatusUpdateFactory.newLatLng(LOCATION)
        bmapview.map.setMapStatus(status)
        //画图标
        val point = LatLng(34.721304, 113.747491)
        //构建Marker图标
//        val bitmap = BitmapDescriptorFactory
//                .fromResource(R.drawable.ic_baidu_logo)
//        val option = MarkerOptions()
//                .position(point)
//                .icon(bitmap)
//        bmapview.map.addOverlay(option)
        var buttom= Button(this@Main2Activity)
        buttom.setText("豫ASK057")
        val drawable = resources.getDrawable(R.drawable.icon_markx)
        drawable.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
        buttom.setCompoundDrawables(null,null,null,drawable)
        val infomwindow= InfoWindow(buttom,point,-100)
        bmapview.map.showInfoWindow(infomwindow)

    }

    override fun onPause() {
        super.onPause()
        bmapview.onPause()
    }

    override fun onResume() {
        super.onResume()
        bmapview.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        bmapview.onDestroy()
    }

}
