storage "file" {
  path = "./vault-data-demo"
}

listener "tcp" {
  address = "127.0.0.1:8111"
  tls_disable = 1
}

disable_mlock=true




/*

$>> export PATH=/home/normie/Downloads/hashicorp:$PATH 	:add a binary to a path
$>> vault server -config ./vault.hcl 	:vault.hcl must be present in path where vault binary is

$>> export VAULT_ADDR=http://localhost:8111		:In separate terminal
$>> vault operator init


$>> export VAULT_TOKEN=hvs<<<SAMPLEKEY FOR VAULT>>>t3RhyqaFf
$>> vault status
Vault is sealed, needs unsealing
$>> vault operator unseal r2fgwOZ<<<SAMPLEKEY FOR UNSEAL>>>9Ekb+TaLjAiN

$>> vault secrets enable -path=secret/ kv
Success! Enabled the kv secrets engine at: secret/

$>> vault kv put secret/SkyView thisIsTheVERYSecureSecretName=veryVerySecurePasswordForConfig
Success! Data written to: secret/SkyView
secret/<ms> :: <ms> must be the microservice where we are fetching/using the secret

*/
