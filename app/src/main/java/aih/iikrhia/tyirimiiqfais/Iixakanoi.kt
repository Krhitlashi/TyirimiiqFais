package aih.iikrhia.tyirimiiqfais

import android.widget.Filter
import java.util.Locale

class Iixakanoi(private val haswikerh: ArrayList<Swikerh>, private val adapter: FefrhiSwikerh) :
    Filter() {
    private var sakasaiiixakanoi: ArrayList<Swikerh> = ArrayList()

    override fun performFiltering(charSequence: CharSequence): FilterResults {
        sakasaiiixakanoi.clear()
        val results = FilterResults()
        for (item in haswikerh) {
            if (item.ksaka.lowercase(Locale.getDefault()).trim { it <= ' ' }
                    .contains(charSequence) || item.koocaq.lowercase(
                    Locale.getDefault()
                ).trim { it <= ' ' }
                    .contains(charSequence)
            ) {
                sakasaiiixakanoi.add(item)
            }
        results.count = sakasaiiixakanoi.size
        results.values = sakasaiiixakanoi
        }

        return results
    }

    override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
        adapter.kfiiSwikerh(sakasaiiixakanoi)
    }

    fun getFilteredList(): ArrayList<Swikerh> {
        return sakasaiiixakanoi
    }

}