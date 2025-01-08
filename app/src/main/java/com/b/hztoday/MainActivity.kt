package com.b.hztoday


import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonToday: Button = findViewById(R.id.buttonToday)
        val buttonTomorrow: Button = findViewById(R.id.buttonTomorrow)

        // Set click listeners to display the links in the TextView
        buttonToday.setOnClickListener {
            val today = LocalDate.now().format(DateTimeFormatter.ISO_DATE)
            val link = this.getLink(today);
            this.openLink(link);
        }

        buttonTomorrow.setOnClickListener {
            val tomorrow = LocalDate.now().plusDays(1).format(DateTimeFormatter.ISO_DATE)
            val link = this.getLink(tomorrow);
            this.openLink(link);
        }
    }

    private fun getLink(date: String) = "https://prodaja.hzpp.hr/hr/Ticket/Journey?StartId=74201&DestId=72480&ReturnFromId=72480&DepartureDate=$date&ReturnDepartureDate=$date&DirectTrains=True&Class=2&ReturnTrip=True&Passenger1Count=1&Passenger2Count=0&Benefit1Id=12&Bicycle=False&Reservation=False&ReturnBicycle=False&ReturnReservation=False"
    private fun openLink(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intent)
    }
}
