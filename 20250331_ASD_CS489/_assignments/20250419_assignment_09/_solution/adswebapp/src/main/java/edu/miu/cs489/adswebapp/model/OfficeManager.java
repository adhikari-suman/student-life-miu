package edu.miu.cs489.adswebapp.model;

import edu.miu.cs489.adswebapp.security.model.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "office_managers")
@Data
public class OfficeManager extends User {
}
