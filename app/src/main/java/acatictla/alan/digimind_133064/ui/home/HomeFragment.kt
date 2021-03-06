package acatictla.alan.digimind_133064.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import acatictla.alan.digimind_133064.R
import acatictla.alan.digimind_133064.recordatorio
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.vista_recordatorios.view.*


class HomeFragment : Fragment() {

    private var adaptador:AdaptadorRecordatorios? = null

    companion object{
        var recordatorios = ArrayList<recordatorio>()
        var first = true
    }
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        if(first){
            cargarRecordatorios()
            first = false
        }

        adaptador = AdaptadorRecordatorios(root.context,recordatorios)
        root.gridView.adapter=adaptador

        return root
    }

    fun cargarRecordatorios(){
        recordatorios.add(recordatorio("Estudiar", arrayListOf("Lunes, Viernes"),"13:00"))
        recordatorios.add(recordatorio("Practicar", arrayListOf("Martes"),"15:00"))
        recordatorios.add(recordatorio("Cita", arrayListOf("Miercoles"),"11:00"))
        recordatorios.add(recordatorio("Tarea", arrayListOf("Lunes, Sabado"),"14:00"))
        recordatorios.add(recordatorio("Cine", arrayListOf("Jueves"),"16:00"))
        recordatorios.add(recordatorio("Cocinar", arrayListOf("Viernes"),"13:00"))
        recordatorios.add(recordatorio("Leer", arrayListOf("Lunes, Martes"),"17:00"))
        recordatorios.add(recordatorio("Dentista", arrayListOf("Sabado"),"18:00"))
        recordatorios.add(recordatorio("Teatro", arrayListOf("Domingo"),"20:00"))
        recordatorios.add(recordatorio("Paseo", arrayListOf("Lunes"),"10:00"))
        recordatorios.add(recordatorio("Jugar", arrayListOf("Sabado"),"21:00"))
        recordatorios.add(recordatorio("Entrenar", arrayListOf("Sabado"),"22:00"))
    }

    private class AdaptadorRecordatorios: BaseAdapter {

        var recordatorios = ArrayList<recordatorio>()
        var contexto: Context? = null

        constructor(contexto:Context,recordatorios: ArrayList<recordatorio>){
            this.contexto = contexto
            this.recordatorios=recordatorios
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var recordar = recordatorios[position]
            var inflador = LayoutInflater.from(contexto)
            var vista = inflador.inflate(R.layout.vista_recordatorios,null)

            vista.recordatorioNombre.text = recordar.nombre
            vista.recordatorioFrecu.text = recordar.frecuencia.toString()
            vista.recordatorioHora.text = recordar.hora

            return vista
        }

        override fun getItem(position: Int): Any {
            return  recordatorios[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return recordatorios.size
        }


    }

}
