package med.voll.api.medico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.direccion.Direccion;

@Table(name = "medicos") //Indicar que es una tabla en la persistencia de la Base de datos
@Entity(name = "Medico") //Marcar la entidad que es
@Getter //Anotacion de "lombok", que al compilar el codigo crea todos los Getter (Get)
@NoArgsConstructor //Anotacion de "lombok", que al compilar el codigo crea todos los Constructores sin parametros
@AllArgsConstructor //Anotacion de "lombok", que al compilar el codigo crea todos los Contructores con parametros
@EqualsAndHashCode(of = "id") //Anotacion de "lombok",
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String telefono;
    private String documento;
    private Boolean activo;
    @Enumerated(EnumType.STRING)
    private Especialidad especialidad;
    @Embedded //Embedded enlazara lo mismo a la clase donde este la etiqueta @Embeddable (En este caso, es la clase "Direccion"
    private Direccion direccion;


    public Medico(DatosRegistroMedico datosRegistroMedico) { //Constructor creado para usarlo en medicoReposity.save en la clase MedicoController
        //mapeo de los parametros que debe de seguir "datosRegistroMedio" en MedicoRespotory
        this.activo = true;
        this.nombre = datosRegistroMedico.nombre();
        this.email = datosRegistroMedico.email();
        this.telefono = datosRegistroMedico.telefono();
        this.documento = datosRegistroMedico.documento();
        this.especialidad = datosRegistroMedico.especialidad();
        this.direccion = new Direccion(datosRegistroMedico.direccion());
    }

    public void actualizarDatos(DatosActualizarMedico datosActualizarMedico) {
        if(datosActualizarMedico.nombre() != null){
            this.nombre = datosActualizarMedico.nombre();
        }
        if(datosActualizarMedico.documento() != null){
            this.documento = datosActualizarMedico.documento();
        }

        if(datosActualizarMedico.direccion() != null){
            this.direccion = direccion.actualizarDatos(datosActualizarMedico.direccion());
        }
    }

    public void desactivarMedico() {
        this.activo = false;
    }
}
