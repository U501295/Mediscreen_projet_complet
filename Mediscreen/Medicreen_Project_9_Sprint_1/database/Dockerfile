# syntax=docker/dockerfile:1
FROM mysql:8.0.31

ENV MYSQL_DATABASE=MediScreenP9 \
    MYSQL_ROOT_PASSWORD=rootroot

ADD DataBaseCreate.sql /docker-entrypoint-initdb.d/