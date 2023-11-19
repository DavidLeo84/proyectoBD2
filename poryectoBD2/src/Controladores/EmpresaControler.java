package Controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aplicacion.Main;
import conexion.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import objects.Categoria;

public class EmpresaControler {

	Conexion conexion = new Conexion();
	Connection con = conexion.conectar();

	private Main aplicacion;
	
    public Main getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(Main aplicacion) {
		this.aplicacion = aplicacion;
	}
	
	@FXML
    void initialize() {
		//categoriacomboBox_cargarCategoriaPadre();
    }
	
    @FXML
    private ComboBox<Categoria> cbox_categoriaPadre;
    
    @FXML
    private Button btnCategoriaActualizar;

    @FXML
    private Button btnCategoriaBuscar;

    @FXML
    private Button btnCategoriaEliminar;

    @FXML
    private Button btnCategoriaInsertar;

    @FXML
    private Button btnHospedajeEliminar;

    @FXML
    private Button btn_ActualizarHospedaje;

    @FXML
    private Button btn_BuscarHospedaje;

    @FXML
    private Button btn_CrearHospedaje;

    @FXML
    private Button btn_DestinoCrear;

    @FXML
    private Button btn_articuloActualizar;

    @FXML
    private Button btn_articuloBuscar;

    @FXML
    private Button btn_articuloCrear;

    @FXML
    private Button btn_destinoActualizar;

    @FXML
    private Button btn_destinoBuscar;

    @FXML
    private Button btn_destinoEliminar;

    @FXML
    private Button btn_habitacionActualizar;

    @FXML
    private Button btn_habitacionBuscar;

    @FXML
    private Button btn_habitacionCrerar;

    @FXML
    private Button btn_habitacionEliminar;

    @FXML
    private TextField btn_hospedajeDescripcion;

    @FXML
    private TextField btn_hospedajeTipo;

    @FXML
    private TextField btn_hospedajeUbicacion;

    @FXML
    private TextField btn_hospedajeestadoContrato;

    @FXML
    private TextField btn_hospedajenombre;

    @FXML
    private TextField txt_ArticuloMarca;

    @FXML
    private TextField txt_ArticuloModelo;

    @FXML
    private TextArea txt_CategoriaDescripcion;

    @FXML
    private TextField txt_HabitacionCategoria;

    @FXML
    private TextField txt_HabitacionidHospedaje;

    @FXML
    private TextField txt_articuloCalidad;

    @FXML
    private TextField txt_articuloCantidadStock;

    @FXML
    private TextField txt_articuloDescripcion;

    @FXML
    private Button txt_articuloEliminar;

    @FXML
    private TextField txt_articuloImagen;

    @FXML
    private TextField txt_articuloPreciounitario;

    @FXML
    private TextField txt_articuloPresentacion;

    @FXML
    private TextField txt_articuloid;

    @FXML
    private TextField txt_articulonombre;

    @FXML
    private TextField txt_categoriaNombre;

    @FXML
    private TextField txt_categoriaid;

    @FXML
    private TextField txt_destinoDescripcion;

    @FXML
    private TextField txt_destinoNombre;

    @FXML
    private TextField txt_destinoid;

    @FXML
    private TextField txt_habitacionCantPersonas;

    @FXML
    private TextField txt_habitacionDescripcion;

    @FXML
    private TextField txt_habitacionNombre;

    @FXML
    private TextField txt_habitacionPrecioNoche;

    @FXML
    private TextField txt_habitacionid;

    @FXML
    private TextField txt_hospedajeid;

    
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //*************************************************CATEGORIA********************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    
    @FXML
    void crearCategoria(ActionEvent event) {
         String sql = "INSERT INTO categoria (idCategoria, nombre, descripcion) VALUES (?, ?, ? )";

         try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
             // Establecer los valores de los par�metros
             preparedStatement.setString(1, txt_categoriaid.getText());
             preparedStatement.setString(2, txt_categoriaNombre.getText());
             preparedStatement.setString(3, txt_CategoriaDescripcion.getText());
           //  preparedStatement.setInt(4, cbox_categoriaPadre.getValue().getIdCategoria());
            // preparedStatement.setString(4, null);
           //  preparedStatement.setString(5, "Bien");

             // Ejecutar la inserci�n
             int filasAfectadas = preparedStatement.executeUpdate();

             if (filasAfectadas > 0) {
                 System.out.println("Inserci�n exitosa");
             } else {
                 System.out.println("La inserci�n no tuvo �xito");
             }
         } catch (SQLException e) {
			e.printStackTrace();
		}
    //	categoriacomboBox_cargarCategoriaPadre();
    }

    @FXML
    void buscarCategoria(ActionEvent event) {
   
    	 String sql = "SELECT * FROM Categoria WHERE idCategoria=?";
         try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
             // Establecer el idCategoria como par�metro
             preparedStatement.setString(1, txt_categoriaid.getText());

             // Ejecutar la consulta
             ResultSet resultSet = preparedStatement.executeQuery();

             // Verificar si se encontr� la categor�a
             if (resultSet.next()) {
                 // Obtener los valores de las columnas
                 String nombre = resultSet.getString("nombre");
                 String descripcion = resultSet.getString("descripcion");
                 int idCategoriaPadre = resultSet.getInt("idCategoriaPadre");
                 // Llenar los valores en campos (reemplaza esto con tu l�gica espec�fica)
                 txt_categoriaNombre.setText(nombre);
                 txt_CategoriaDescripcion.setText(descripcion);
                 //cbox_categoriaPadre.setText(String.valueOf(idCategoriaPadre));
                
                 System.out.println("Categor�a encontrada y valores llenados en campos.");
             } else {
                 System.out.println("Categor�a no encontrada para el idCategoria proporcionado.");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }

    @FXML
    void actualizarCategoria(ActionEvent event) {
    	 String sql = "UPDATE categoria SET nombre=?, descripcion = ? where idCategoria = ?";

         try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
             // Establecer los valores de los par�metros
             preparedStatement.setString(1, txt_categoriaNombre.getText());
             preparedStatement.setString(2, txt_CategoriaDescripcion.getText());
             preparedStatement.setString(3, txt_categoriaid.getText());
             //  preparedStatement.setInt(4, cbox_categoriaPadre.getValue().getIdCategoria());
             int filasAfectadas = preparedStatement.executeUpdate();

             if (filasAfectadas > 0) {
                 System.out.println("Inserci�n exitosa");
             } else {
                 System.out.println("La inserci�n no tuvo �xito");
             }
         } catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @FXML
    void eliminarCategoria(ActionEvent event) {
    	  String sql = "DELETE categoria where idCategoria= ? ";
          try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
              // Establecer los valores de los par�metros
              preparedStatement.setString(1, txt_categoriaid.getText());

              // Ejecutar la inserci�n
              int filasAfectadas = preparedStatement.executeUpdate();

              if (filasAfectadas > 0) {
                  System.out.println("eliminacion exitosa");
              } else {
                  System.out.println("La inserci�n no tuvo �xito");
              }
          } catch (SQLException e) {
 			e.printStackTrace();
 		}
    }   
	
   //*******************************************
    private void categoriacomboBox_cargarCategoriaPadre() {
    	//Connection con = conexion.conectar();
    	cbox_categoriaPadre.getItems().clear();
        String sql = "SELECT idCategoria, nombre FROM Categoria WHERE ROWNUM <= 5"; // Consulta SQL para obtener datos de Oracle
        try (PreparedStatement preparedStatement = con.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            List<Categoria> categorias = new ArrayList<>();// Lista para almacenar los datos de la consulta
            while (resultSet.next()) {  // Iterar sobre los resultados y agregarlos a la lista
            	 int id = resultSet.getInt("idCategoria");
                 String nombre = resultSet.getString("nombre");
                 categorias.add(new Categoria(id, nombre));
            }
            cbox_categoriaPadre.getItems().addAll(categorias);// Agregar los datos al ComboBox
        } catch (SQLException e) {
            e.printStackTrace();
        }
     //	conexion.desconectar(con);
    }

    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //*********************************************ARTICULO*********************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    

    @FXML
    void articuloBuscar(ActionEvent event) {
    	String sql = "SELECT * FROM Articulo WHERE idArticulo=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer el idArticulo como par�metro
            preparedStatement.setString(1, txt_articuloid.getText());
            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();
            // Verificar si se encontr� el art�culo
            if (resultSet.next()) {
                // Obtener los valores de las columnas
                String nombre = resultSet.getString("nombre");
                int precioUnitario = resultSet.getInt("precioUnitario");
                int cantidadStock = resultSet.getInt("cantidadStock");
                String descripcion = resultSet.getString("descripcion");
                String marca = resultSet.getString("marca");
                String modelo = resultSet.getString("modelo");
                String presentacion = resultSet.getString("presentacion");
                String imagen = resultSet.getString("imagen");
                String calidad = resultSet.getString("calidad");

                // Llenar los valores en campos (reemplaza esto con tu l�gica espec�fica)
                txt_articulonombre.setText(nombre);
                txt_articuloPreciounitario.setText(String.valueOf(precioUnitario));
                txt_articuloCantidadStock.setText(String.valueOf(cantidadStock));
                txt_articuloDescripcion.setText(descripcion);
                txt_ArticuloMarca.setText(marca);
                txt_ArticuloModelo.setText(modelo);
                txt_articuloPresentacion.setText(presentacion);
                txt_articuloImagen.setText(imagen);
                txt_articuloCalidad.setText(calidad);

                System.out.println("Art�culo encontrado y valores llenados en campos.");
            } else {
                System.out.println("Art�culo no encontrado para el idArticulo proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void articuloCrear(ActionEvent event) {
    	String sql = "INSERT INTO Articulo (idArticulo, nombre, precioUnitario, cantidadStock, descripcion, marca, modelo, presentacion, imagen, calidad ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los par�metros
            preparedStatement.setString(1, txt_articuloid.getText());
            preparedStatement.setString(2, txt_articulonombre.getText());
            preparedStatement.setString(3, txt_articuloPreciounitario.getText());
            preparedStatement.setString(4, txt_articuloCantidadStock.getText());
            preparedStatement.setString(5, txt_articuloDescripcion.getText());
            preparedStatement.setString(6, txt_ArticuloMarca.getText());
            preparedStatement.setString(7, txt_ArticuloModelo.getText());
            preparedStatement.setString(8, txt_articuloPresentacion.getText());
            preparedStatement.setString(9, txt_articuloImagen.getText());
            preparedStatement.setString(10, txt_articuloCalidad.getText());
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserci�n exitosa");
            } else {
                System.out.println("La inserci�n no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void articuloEliminar(ActionEvent event) {
    	 String sql = "DELETE FROM Articulo WHERE idArticulo = ?";

         try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
             // Establecer el valor del par�metro
             preparedStatement.setString(1, txt_articuloid.getText());

             // Ejecutar la eliminaci�n
             int filasAfectadas = preparedStatement.executeUpdate();

             if (filasAfectadas > 0) {
                 System.out.println("Eliminaci�n exitosa");
             } else {
                 System.out.println("La eliminaci�n no tuvo �xito");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    
    @FXML
    void ArticuloActualizar(ActionEvent event) {
    	String sql = "UPDATE Articulo SET nombre=?, precioUnitario=?, cantidadStock=?, descripcion=?, " +
                "marca=?, modelo=?, presentacion=?, imagen=?, calidad=? WHERE idArticulo=?";

		   try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			   
		       preparedStatement.setString(1, txt_articulonombre.getText());
		       preparedStatement.setString(2, txt_articuloPreciounitario.getText());
		       preparedStatement.setString(3, txt_articuloCantidadStock.getText());
		       preparedStatement.setString(4, txt_articuloDescripcion.getText());
		       preparedStatement.setString(5, txt_ArticuloMarca.getText());
		       preparedStatement.setString(6, txt_ArticuloModelo.getText());
		       preparedStatement.setString(7, txt_articuloPresentacion.getText());
		       preparedStatement.setString(8, txt_articuloImagen.getText());
		       preparedStatement.setString(9, txt_articuloCalidad.getText());
		       preparedStatement.setString(10, txt_articuloid.getText());
		       
		       int filasAfectadas = preparedStatement.executeUpdate();
		
		       if (filasAfectadas > 0) {
		           System.out.println("Actualizaci�n exitosa");
		       } else {
		           System.out.println("La actualizaci�n no tuvo �xito");
		       }
		   } catch (SQLException e) {
		       e.printStackTrace();
		   }
    }
    
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //*************************************************HOSPEDAJE********************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************

    @FXML
    void hospedajeCrear(ActionEvent event) {
    	String sql = "INSERT INTO Hospedaje (idHospedaje, nombre, descripcion, ubicacion, estadoContrato, tipo) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los par�metros
            preparedStatement.setString(1, txt_hospedajeid.getText());
            preparedStatement.setString(2, btn_hospedajenombre.getText());
            preparedStatement.setString(3, btn_hospedajeDescripcion.getText());
            preparedStatement.setString(4, btn_hospedajeUbicacion.getText());
            preparedStatement.setString(5, btn_hospedajeestadoContrato.getText());
            preparedStatement.setString(6, btn_hospedajeTipo.getText());

            // Ejecutar la inserci�n
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Inserci�n exitosa en la tabla Hospedaje");
            } else {
                System.out.println("La inserci�n en la tabla Hospedaje no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void hospedajeBuscar(ActionEvent event) {
    	String sql = "SELECT * FROM Hospedaje WHERE idHospedaje=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer el idHospedaje como par�metro
            preparedStatement.setString(1, txt_hospedajeid.getText());

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verificar si se encontr� el hospedaje
            if (resultSet.next()) {
                // Obtener los valores de las columnas
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                String ubicacion = resultSet.getString("ubicacion");
                String estadoContrato = resultSet.getString("estadoContrato");
                String tipo = resultSet.getString("tipo");

                // Llenar los valores en campos (reemplaza esto con tu l�gica espec�fica)
                btn_hospedajenombre.setText(nombre);
                btn_hospedajeDescripcion.setText(descripcion);
                btn_hospedajeUbicacion.setText(ubicacion);
                btn_hospedajeestadoContrato.setText(estadoContrato);
                btn_hospedajeTipo.setText(tipo);

                System.out.println("Hospedaje encontrado y valores llenados en campos.");
            } else {
                System.out.println("Hospedaje no encontrado para el idHospedaje proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void hospedajeActualizar(ActionEvent event) {
    	String sql = "UPDATE Hospedaje SET nombre=?, descripcion=?, ubicacion=?, estadoContrato=?, tipo=? WHERE idHospedaje=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los par�metros
            preparedStatement.setString(1, btn_hospedajenombre.getText());
            preparedStatement.setString(2, btn_hospedajeDescripcion.getText());
            preparedStatement.setString(3, btn_hospedajeUbicacion.getText());
            preparedStatement.setString(4, btn_hospedajeestadoContrato.getText());
            preparedStatement.setString(5, btn_hospedajeTipo.getText());
            preparedStatement.setString(6, txt_hospedajeid.getText());

            // Ejecutar la actualizaci�n
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Actualizaci�n exitosa en la tabla Hospedaje");
            } else {
                System.out.println("La actualizaci�n en la tabla Hospedaje no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void hospedajeEliminar(ActionEvent event) {
    	String sql = "DELETE FROM Hospedaje WHERE idHospedaje=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, txt_hospedajeid.getText());
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Eliminaci�n exitosa en la tabla Hospedaje");
            } else {
                System.out.println("La eliminaci�n en la tabla Hospedaje no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //**************************************HABITACION************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    
    @FXML
    void CrearHabitacion(ActionEvent event) {
    	String sql = "INSERT INTO Habitacion (idHabitacion, idHospedaje, nombre, categoria, cantidadPersonas, precioNoche, descripcion) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los par�metros
            preparedStatement.setString(1, txt_habitacionid.getText());
            preparedStatement.setString(2, txt_HabitacionidHospedaje.getText()); //txt_HabitacionidHospedaje
            preparedStatement.setString(3, txt_habitacionNombre.getText());
            preparedStatement.setString(4, txt_HabitacionCategoria.getText());
            preparedStatement.setString(5, txt_habitacionCantPersonas.getText());
            preparedStatement.setString(6, txt_habitacionPrecioNoche.getText());
            preparedStatement.setString(7, txt_habitacionDescripcion.getText());
            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("Inserci�n exitosa en la tabla Habitacion");
            } else {
                System.out.println("La inserci�n en la tabla Habitacion no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void buscarHabitacion(ActionEvent event) {
    	String sql = "SELECT * FROM Habitacion WHERE idHabitacion=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer el idHabitacion como par�metro
            preparedStatement.setString(1, txt_habitacionid.getText());

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verificar si se encontr� la habitaci�n
            if (resultSet.next()) {
                // Obtener los valores de las columnas
                String nombre = resultSet.getString("nombre");
                String categoria = resultSet.getString("categoria");
                int idHospedaje = resultSet.getInt("idHospedaje");
                int cantidadPersonas = resultSet.getInt("cantidadPersonas");
                int precioNoche = resultSet.getInt("precioNoche");
                String descripcion = resultSet.getString("descripcion");

                // Llenar los valores en campos (reemplaza esto con tu l�gica espec�fica)
                txt_habitacionNombre.setText(nombre);
                txt_HabitacionCategoria.setText(categoria);
                txt_HabitacionidHospedaje.setText(String.valueOf(idHospedaje));
                txt_habitacionCantPersonas.setText(String.valueOf(cantidadPersonas));
                txt_habitacionPrecioNoche.setText(String.valueOf(precioNoche));
                txt_habitacionDescripcion.setText(descripcion);

                System.out.println("Habitaci�n encontrada y valores llenados en campos.");
            } else {
                System.out.println("Habitaci�n no encontrada para el idHabitacion proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void actualizarHabitacion(ActionEvent event) {
    	String sql = "UPDATE Habitacion SET nombre=?, categoria=?, idHospedaje=?, cantidadPersonas=?, precioNoche=?, descripcion=? WHERE idHabitacion=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los par�metros
            preparedStatement.setString(1, txt_habitacionNombre.getText());
            preparedStatement.setString(2, txt_HabitacionCategoria.getText());
            preparedStatement.setString(3, txt_HabitacionidHospedaje.getText());
            preparedStatement.setString(4, txt_habitacionCantPersonas.getText());
            preparedStatement.setString(5, txt_habitacionPrecioNoche.getText());
            preparedStatement.setString(6, txt_habitacionDescripcion.getText());
            preparedStatement.setString(7, txt_habitacionid.getText());

            // Ejecutar la actualizaci�n
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Actualizaci�n exitosa en la tabla Habitacion");
            } else {
                System.out.println("La actualizaci�n en la tabla Habitacion no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void eliminarHabitacion(ActionEvent event) {
    	String sql = "DELETE FROM Habitacion WHERE idHabitacion=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer el valor del par�metro
            preparedStatement.setString(1, txt_habitacionid.getText());

            // Ejecutar la eliminaci�n
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Eliminaci�n exitosa en la tabla Habitacion");
            } else {
                System.out.println("La eliminaci�n en la tabla Habitacion no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
   
    
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //********************************* DESTINO ***************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    @FXML
    void DestinoCrear(ActionEvent event) {
    	String sql = "INSERT INTO Destino (idDestino, nombreDestino, descripcion) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            preparedStatement.setString(1, txt_destinoid.getText());
            preparedStatement.setString(2, txt_destinoNombre.getText());
            preparedStatement.setString(3, txt_destinoDescripcion.getText());
            
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Inserci�n exitosa en la tabla Destino");
            } else {
                System.out.println("La inserci�n en la tabla Destino no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btn_destinoBuscar(ActionEvent event) {
    	String sql = "SELECT * FROM Destino WHERE idDestino=?";
        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer el idDestino como par�metro
            preparedStatement.setString(1, txt_destinoid.getText());

            // Ejecutar la consulta
            ResultSet resultSet = preparedStatement.executeQuery();

            // Verificar si se encontr� el destino
            if (resultSet.next()) {
                // Obtener los valores de las columnas
                String nombreDestino = resultSet.getString("nombreDestino");
                String descripcion = resultSet.getString("descripcion");

                // Llenar los valores en campos (reemplaza esto con tu l�gica espec�fica)
                txt_destinoNombre.setText(nombreDestino);
                txt_destinoDescripcion.setText(descripcion);

                System.out.println("Destino encontrado y valores llenados en campos.");
            } else {
                System.out.println("Destino no encontrado para el idDestino proporcionado.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void btn_destinoActualizar(ActionEvent event) {
    	String sql = "UPDATE Destino SET nombreDestino=?, descripcion=? WHERE idDestino=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer los valores de los par�metros
            preparedStatement.setString(1, txt_destinoNombre.getText());
            preparedStatement.setString(2, txt_destinoDescripcion.getText());
            preparedStatement.setString(3, txt_destinoid.getText());

            // Ejecutar la actualizaci�n
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Actualizaci�n exitosa en la tabla Destino");
            } else {
                System.out.println("La actualizaci�n en la tabla Destino no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void destinoEliminar(ActionEvent event) {
    	String sql = "DELETE FROM Destino WHERE idDestino=?";

        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
            // Establecer el valor del par�metro
            preparedStatement.setString(1, txt_destinoid.getText());

            // Ejecutar la eliminaci�n
            int filasAfectadas = preparedStatement.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Eliminaci�n exitosa en la tabla Destino");
            } else {
                System.out.println("La eliminaci�n en la tabla Destino no tuvo �xito");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //****************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    
    
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //****************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    //***********************************************************************************************************************************************************************************************************************
    
   
}
