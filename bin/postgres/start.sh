#!/usr/bin/env bash
#!/bin/bash
#!/usr/bin/env bash

set -euo pipefail

#mkdir -p "$HOME"/.local/docker/postgresql
#docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=local -d -p 5432:5432 -e PGDATA=/var/lib/postgres

mkdir -p C:\Users\shadm\docker\databases\postgresql
#docker run --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=local -p 5432:5432 -d postgres
docker run --rm --name pg-docker -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=local -d -p 5432:5432 -e PGDATA=/var/lib/postgresql/data/pgdata -v 'C:\Users\shadm\docker\data\postgresql':/var/lib/postgresql/data postgres
