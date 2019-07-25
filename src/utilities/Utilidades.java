package utilities;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Cita;
import beans.Mascota;

public class Utilidades {
	public static String transformarJson(List<Cita> citasMascota) {
		JSONArray array=new JSONArray();

		for(Cita ct:citasMascota) {
			JSONObject ob=new JSONObject();
			//Convertrilo a String para que en respuestaJson se pueda parsear
			//Json sólo reconoce valores de texto y numéricos
			ob.put("fechaCita", ct.getFechaCita().toString());
			ob.put("idCita", ct.getIdCita());
			ob.put("idMascota", ct.getIdMascota());
			array.add(ob);
		}
		return array.toJSONString();
	}
	
}
