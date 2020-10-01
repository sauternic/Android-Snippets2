
// dp in pixel wie es z.B. in setMartins( pixel_int(100), 0, 0, 0) gebraucht wird...


Auf einem Gerät sind         100dp -> 350px
Auf einem anderen Gerät sind 100dp -> 300px
Je nach Bildschirmauflösung...

Funktion unten berechnet das richtige Verhältnis dp zu Pixel...


int pixel_int(int dp_wie_in_xml) {
        return (int) (dp_wie_in_xml * Resources.getSystem().getDisplayMetrics().density);
    }