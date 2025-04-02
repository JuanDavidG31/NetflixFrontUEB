package co.edu.unbosque.model;
/**
 * Data Transfer Object (DTO) para representar datos de Excel relacionados con el usuario y la fecha.
 * Esta clase se utiliza para transferir datos entre diferentes capas de la aplicación,
 * especialmente para operaciones de lectura y escritura en archivos Excel o CSV.
 */
public class ExcelDTO {
	/**
     * Identificador único del registro en Excel.
     */
	private Integer id;
	/**
     * Nombre de usuario asociado al registro.
     */
	private String user;
	/**
     * Fecha asociada al registro, generalmente representando una fecha y hora.
     */
	private String date;
	/**
     * Constructor predeterminado sin argumentos.
     */
	public ExcelDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
     * Constructor con argumentos para inicializar los campos de usuario y fecha.
     * @param user Nombre de usuario a establecer.
     * @param date Fecha a establecer.
     */
	public ExcelDTO(String user, String date) {
		super();
		this.user = user;
		this.date = date;
	}
	/**
     * Obtiene el identificador del registro.
     * @return El identificador del registro.
     */
	public Integer getId() {
		return id;
	}
	/**
     * Establece el identificador del registro.
     * @param id El identificador del registro a establecer.
     */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
     * Obtiene el nombre de usuario.
     * @return El nombre de usuario.
     */
	public String getUser() {
		return user;
	}
	/**
     * Establece el nombre de usuario.
     * @param user El nombre de usuario a establecer.
     */
	public void setUser(String user) {
		this.user = user;
	}
	/**
     * Obtiene la fecha.
     * @return La fecha.
     */
	public String getDate() {
		return date;
	}
	/**
     * Establece la fecha.
     * @param date La fecha a establecer.
     */
	public void setDate(String date) {
		this.date = date;
	}
	/**
     * Devuelve una representación en cadena del objeto ExcelDTO.
     * @return Una cadena que representa el objeto ExcelDTO.
     */
	@Override
	public String toString() {
		return "ExcelDTO [id=" + id + ", user=" + user + ", date=" + date + "]";
	}

}
