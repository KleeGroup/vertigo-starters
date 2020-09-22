package ${package}.${businessModuleLowerCase};

import io.vertigo.basics.constraint.ConstraintStringLength;
import io.vertigo.basics.formatter.FormatterDefault;
import io.vertigo.basics.formatter.FormatterId;
import io.vertigo.datamodel.smarttype.annotations.Constraint;
import io.vertigo.datamodel.smarttype.annotations.Formatter;
import io.vertigo.datamodel.smarttype.annotations.SmartTypeDefinition;
import io.vertigo.datamodel.smarttype.annotations.SmartTypeProperty;


public enum ${businessModule}SmartTypes {
	
	@SmartTypeDefinition(Long.class)
	@Formatter(clazz = FormatterId.class, arg = "")
	@SmartTypeProperty(property = "storeType", value = "NUMERIC")
	Id,
	

	@SmartTypeDefinition(String.class)
	@Formatter(clazz = FormatterDefault.class)
	@Constraint(clazz = ConstraintStringLength.class, arg = "100", msg = "")
	@SmartTypeProperty(property = "storeType", value = "VARCHAR(100)")
	Label,
	

	@SmartTypeDefinition(String.class)
	@Formatter(clazz = FormatterDefault.class)
	@Constraint(clazz = ConstraintStringLength.class, arg = "500", msg = "")
	@SmartTypeProperty(property = "storeType", value = "VARCHAR(500)")
	LabelLong,
	
	
	@SmartTypeDefinition(Integer.class)
	@Formatter(clazz = FormatterId.class, arg = "")
	@SmartTypeProperty(property = "storeType", value = "NUMERIC")
	Year;
	
}