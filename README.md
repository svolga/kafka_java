1) **Создание docker контейнера с кафкой:**
https://www.baeldung.com/ops/kafka-docker-setup

2) **Файл создания контейнера внутри проекта:** docker-compose.yml


3) **Перейти в терминал кафки:**

docker exec -it <ID контейнера> bash


4) **Команды внутри кафки:** 

**Создание топика digital1 с 1 партицией:**

kafka-topics  --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic digital1

**Создание топика digital10 с 10 партициями:**

kafka-topics  --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 10 --topic digital10


**Прочитать описание топика:**

kafka-topics --describe --topic digital10 --bootstrap-server localhost:9092

**Скрин:**
http://joxi.ru/p27Lpd8fKBZgeA

**Написать в топик:**

kafka-console-producer --topic digital10 --bootstrap-server localhost:9092

This is my first event

This is my second event

Остановить писать сообщения: Ctrl+C


**В отдельном окне терминала (docker exec -it <ID контейнера> bash) запустить команду для чтения топика:**

kafka-console-consumer --topic digital10 --from-beginning --bootstrap-server localhost:9092

**Скрин:**
http://joxi.ru/zAN57l0ivDwz42


**Работа с группами:**

Создавать группы из консоли не нужно. Требуется добавить group_id для консьюмера в коде

https://kafka-school.ru/blogs/kafka-groups/

**Список групп консьюмеров:**

kafka-consumer-groups --bootstrap-server localhost:9092 --list

Описание группы:
kafka-consumer-groups --bootstrap-server localhost:9092 --describe --group testGroup01


5) 


Команды docker:
https://docs.docker.com/engine/reference/commandline/compose_run/



Ссылка на git проекта:


Маппинг из контейнера на диск:
volumes:
- ./data:/var/lib/kafka/data



