terraform {
  required_providers {
    keycloak = {
      source  = "mrparkers/keycloak"
      version = ">= 4.4.0"
    }
  }
}


# 1. Connect to Local Keycloak
provider "keycloak" {
  client_id     = "admin-cli"
  username      = var.keycloak_user
  password      = var.keycloak_password
  url           = var.keycloak_url
}

# 2. Define the Realm
resource "keycloak_realm" "myriad_essence" {
  realm        = "myriad-essence"
  enabled      = true
  display_name = "Myriad Essence Ecosystem"

  login_theme  = "keycloakify-starter"

  registration_allowed   = true
  reset_password_allowed = true
  remember_me            = true
  verify_email           = true
  ssl_required           = "external"

// TODO Remove later
  smtp_server {
    host = "maildev"
    port = "1025"
    from = "no-reply@myriad-essence.com"
  }
}

# 3. Define the Configuration Map (The "Source of Truth")
locals {
  clients_config = {
    "myriad-essence-body" = {
      port = "3000"
      name = "Myriad Essence Body"
    }
    "myriad-essence-mind" = {
      port = "3001"
      name = "Myriad Essence Mind"
    }
    "myriad-essence-soul" = {
      port = "3002"
      name = "Myriad Essence Soul"
    }
    "myriad-essence-store" = {
      port = "3003"
      name = "Myriad Essence Store"
    }
    "myriad-essence-community" = {
      port = "3004"
      name = "Myriad Essence Community"
    }
  }
}

# 4. Create Clients
resource "keycloak_openid_client" "apps" {
  for_each = local.clients_config

  realm_id  = keycloak_realm.myriad_essence.id
  client_id = each.key
  name      = each.value.name
  enabled   = true

  access_type                  = "PUBLIC"
  standard_flow_enabled        = true
  direct_access_grants_enabled = false

  valid_redirect_uris = [
    "http://localhost:${each.value.port}/*"
  ]

  web_origins = [
    "http://localhost:${each.value.port}"
  ]
}