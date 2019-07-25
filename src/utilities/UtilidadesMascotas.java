package utilities;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import beans.Mascota;

public class UtilidadesMascotas {
	public static String transformarJsonMascotas(List<Mascota> listaMascota) {
		JSONArray array=new JSONArray();

		for(Mascota mascota:listaMascota) {
			JSONObject ob=new JSONObject();
			//Convertrilo a String para que en respuestaJson se pueda parsear
			//Json sólo reconoce valores de texto y numéricos
			ob.put("idMascota", mascota.getIdMascota());
			ob.put("nombreMascota", mascota.getNombreMascota());
			ob.put("especie", mascota.getEspecie());
			ob.put("raza", mascota.getRaza());
			ob.put("genero", mascota.getGenero());
			ob.put("peso", mascota.getPeso());
			ob.put("edad", mascota.getEdad());

			array.add(ob);
		}
		return array.toJSONString();
	}
}
