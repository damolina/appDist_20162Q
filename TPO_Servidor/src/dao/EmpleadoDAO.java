package dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import converters.RolEmpleadoConverter;
import converters.SucursalConverter;
import dto.EmpleadoDTO;
import entities.Empleado;
import hbt.HibernateUtil;

public class EmpleadoDAO {
	public static EmpleadoDAO instancia;
	
	private static SessionFactory sf = null;

	public static EmpleadoDAO getInstancia(){
		if(instancia == null){
			sf = HibernateUtil.getSessionFactory();
			instancia = new EmpleadoDAO();
		} 
		return instancia;
	}

	/*PRUEBA*/
	public Empleado crearEmpleado(EmpleadoDTO e){
		Session session = sf.openSession();
		session.beginTransaction();
		
		Empleado empleado = new Empleado(e.getCuit(),
										e.getNombre());
		
		empleado.setRolEmpleado(RolEmpleadoConverter.rolEmpleadoToEntity(e.getRolEmpleado()));
				 
		empleado.setSucursal(SucursalConverter.sucursalToEntity(e.getSucursal()));
		
		session.save(empleado);
		
		session.getTransaction().commit();

		session.close();
		
		return empleado;
	}

	public List<Empleado> getEmpleados() {
		Session session = sf.openSession();
		List<Empleado> list = session.createQuery("SELECT e FROM Empleado e").list();
		session.close();
		return list;
	}

	public List<Empleado> getChoferesDisponibles() {
		Session session = sf.openSession();
		List<Empleado> list = session.createQuery("SELECT e "
												+ "FROM Empleado e "
												+ "JOIN e.rolEmpleado r "
												+ "WHERE r.descripcion = 'chofer'").list();
		session.close();
		return list;
	}
	
	public boolean existeEmpleado(String cuit) {
		boolean existeEmpleado 	= false;
		List<Empleado> empleado	= null;
		Session session = sf.openSession();
		empleado = session.createQuery("SELECT 1 "
						   			+ "FROM Empleado e "
						   			+ "WHERE e.cuit = :cuit").setParameter("cuit",cuit).list();
		session.close();

		if(empleado.size() > 0){
			existeEmpleado = true;
		}
		
		return existeEmpleado;
	}
}
