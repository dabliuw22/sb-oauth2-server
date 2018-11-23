# Oauth2 Server

1. Requirements:
	* Java >= 1.8
	* Redis

2. Clone project:

```
git clone https://github.com/dabliuw22/sb-oauth2-server.git
```
3. Run project

4. Open in the preferred web browser: http://localhost:8080/oauth/authorize?client_id=clientapp&redirect_uri=http://localhost:9000/callback&response_type=code&scope=read and login with user: *my.username* and password: *12345*

5. Approve read permission and click on the Authorize button.

6. Copy redirect link code.

7. Obtain access token, replace {your-code} with the copied code:

```
curl -X POST --user clientapp:123456 \
  http://localhost:8080/oauth/token \
  -H 'Cache-Control: no-cache' \
  -H 'accept: application/json' \
  -H 'content-type: application/json' \
  -d '{
	"grant_type": "authorization_code",
	"scope": "read",
	"code": "{your-code}",
	"redirect_uri": "http://localhost:9000/callback"
}'
```
8. Read profile, replace {your-access-token} with the copied access_token:

```
curl -X GET \
  http://localhost:8080/api/profile \
  -H 'Authorization: Bearer {your-access-token}' \
  -H 'Cache-Control: no-cache'
```