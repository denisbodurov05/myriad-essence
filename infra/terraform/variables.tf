variable "keycloak_user" {
  description = "Admin username for Keycloak"
  type        = string
  default     = "admin"
}

variable "keycloak_password" {
  description = "Admin password for Keycloak"
  type        = string
  sensitive   = true 
}

variable "keycloak_url" {
  description = "URL where Keycloak is running"
  type        = string
  default     = "http://localhost:8080"
}