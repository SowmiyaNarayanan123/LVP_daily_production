package com.productioncheck.beans;

import java.io.Serializable;
import java.sql.Timestamp;

public class EnergyPk implements Serializable {

private static final long serialVersionUID = -2809974658862715760L;

private String identifier;
private Timestamp datetime;

public String getIdentifier() {
return identifier;
}

public void setIdentifier(String identifier) {
this.identifier = identifier;
}

public Timestamp getDatetime() {
return datetime;
}

public void setDatetime(Timestamp datetime) {
this.datetime = datetime;
}

public EnergyPk() {
super();
}

public EnergyPk(String identifier, Timestamp datetime) {
super();
this.identifier = identifier;
this.datetime = datetime;
}

@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
return result;
}

@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
EnergyPk other = (EnergyPk) obj;
if (datetime == null) {
if (other.datetime != null)
return false;
} else if (!datetime.equals(other.datetime))
return false;
if (identifier == null) {
if (other.identifier != null)
return false;
} else if (!identifier.equals(other.identifier))
return false;
return true;
}

}
