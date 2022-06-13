

**Grupo 6**


**Turno Facil**

**Use-Case Specification: Sacar Turno**

**Version <1.0>**

*[Note: The following template is provided for use with the Rational Unified Process. Text enclosed in square brackets and displayed in blue italics (style=InfoBlue) is included to provide guidance to the author and should be deleted before publishing the document. A paragraph entered following this style will automatically be set to normal (style=Body Text).]*

*[To customize automatic fields in Microsoft Word (which display a gray background when selected), select File>Properties and replace the Title, Subject and Company fields with the appropriate information for this document. After closing the dialog, automatic fields may be updated throughout the document by selecting Edit>Select All (or Ctrl-A) and pressing F9, or simply click on the field and press F9. This must be done separately for Headers and Footers. Alt-F9 will toggle between displaying the field names and the field contents. See Word help for more information on working with fields.]* 


\1.	Brief Description	4

\2.	Basic Flow of Events	4

\3.	Alternative Flows	4

3.1	<Area of Functionality>	5

3.1.1	< A1 First Alternative Flow >	5

3.1.2	< A2 Second Alternative Flow >	5

\4.	Key Scenarios	5

\5.	Preconditions	5

5.1	< Precondition One >	5

\6.	Postconditions	5

6.1	< Postcondition One >	5

\7.	Extension Points	5

7.1	<Name of Extension Point>	5

\8.	Special Requirements	5

8.1	< First Special Requirement >	6

\9.	Additional Information	6


**Use-Case Specification: <Use-Case Name>** 

*[The following template is provided for a Use-Case Specification, which contains the textual properties of the use case. This document is used with a requirements management tool, such as Rational RequisitePro, for specifying and marking the requirements within the use-case properties.*

*The use-case diagrams can be developed in a visual modeling tool, such as Rational Rose. A use-case report, with all properties, may be generated with Rational SoDA. For more information, see the tool mentors in the Rational Unified Process.]*

1. **Brief Description**

*[The description briefly conveys the role and purpose of the use case. A single paragraph will suffice for this description.]*

1. **Basic Flow of Events**


	1. El caso de uso comienza cuando el paciente quiere sacar un turno.
	2. El sistema solicita que el paciente ingrese el nombre del médico, y un filtro de búsqueda (por obra social y/o especialidad) si así lo desea.
	3. El paciente ingresa el nombre del médico y el filtro de búsqueda.
	4. El sistema informa los días y horarios del médico.
	5. El sistema solicita el rango de fechas y el horario del turno.
	6. El paciente ingresa el rango de fechas y el horario.
	7. El sistema verifica que el turno esté disponible.
	8. El sistema reconoce que el turno está disponible.
	9. El paciente selecciona el turno.
	10.El sistema registra el nuevo turno.
	11.Fin del caso de uso.


1. **Alternative Flows**

**	7.  El sistema verifica que el turno esté disponible.

`		`7.1 El sistema reconoce que el turno no está disponible.

`		`7.2 El sistema da la opción de mostrar los turnos de la semana próxima.

`		`7.3 El paciente selecciona que no desea ver los turnos de la próxima semana.

`		`7.4 Fin del caso de uso.

`	`7.2 El sistema da la opción de mostrar los turnos de la semana próxima.

`		`7.2.1 El paciente selecciona que desea ver los turnos de la semana próxima.

`		`7.2.2 Volver al paso 6.

1. **<Area of Functionality>**

	En este caso de uso, el area de funcionalidad entra en papel cuando se quiere sacar un turno y este mismo puede estar disponible o no. Aqui es donde surgen los flujos alternativos.

1. *< A1 First Alternative Flow >*

	El caso de uso alternativo refleja la situación en la que el paciente selecciona un turno que no está disponible. Se le da la opción a este mismo de ver los turnos de la próxima semana.

1. < An Alternative Subflow >

`	En el primer caso de uso alternativo se le da la opción de ver los turnos de la semana próxima. Si elige que desea verlos, se vuelve al paso 6, donde este ingresa nuevamente el horario.


1. **Preconditions**
	1. **El paciente no cuenta con ningún turno y desea sacar uno.**
1. **Postconditions**
	1. **El sistema registra el turno del paciente.**
1. **Extension Points**

	No cuenta con puntos de extensión.

1. **Special Requirements**

	Al momento de querer utilizar la funcionalidad de "Sacar Turno" la aplicacion debe de funcionar correcta y fluidamente.


