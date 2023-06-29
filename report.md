```
University: [ITMO University](https://itmo.ru/ru/)
Faculty: [FICT](https://fict.itmo.ru)
Course: Application containerization and orchestration
Year: 2023
Module: Internet of Things
Authors: German Ilya Andreevich (k4110c), Koshevsky Lev Sergeevich (k4113c)
Date of create: 15.06.2023
Date of finished: 30.06.2023
```
## Ход работы
Создаём образ нашей программы при помощи `docker build . -t cases`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/34d05be3-05d7-4353-b34d-dcd370f67108)
Проверяем список контейнеров командой `docker ps`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/8e31791c-815b-47e7-af99-3873f44e6499)
`docker login`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/42eabd26-80ad-47f5-ad87-385fc1d2ec58)
Пушим образ в докерхаб `docker push 2651915/cases:latest`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/b2f9eceb-6afd-4337-b422-ab4f4817f03d)
Проверяем наличие образа в DockerHub
![image](https://github.com/LevKoshevskii/cases/assets/116584865/e0e427a4-0689-4207-99a3-764342e7288d)
Запускаем миникуб командой `minikube start`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/ac53e5e9-bb19-4e7a-b004-950b6f775209)
Создаём неймспейс при помощи `kubectl create namespace cases` 
![image](https://github.com/LevKoshevskii/cases/assets/116584865/b5d9f58f-d7cb-4693-8862-cd35d2b76505)
Создаём деплоймент и помещаем его в созданный ранее неймспейс командой `kubectl apply -f deployment.yaml -n cases`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/2b90edc1-974f-485f-afa5-2332352b2cc4)
Создаём сервис командой `kubectl apply -f service.yaml -n cases`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/5de37f62-2026-4489-bf3b-c376c8d11e36)
Проверяем 
![image](https://github.com/LevKoshevskii/cases/assets/116584865/28adb853-4434-4959-a9b8-9a68a4ad5b3e)
![image](https://github.com/LevKoshevskii/cases/assets/116584865/e0bcf2ca-2636-49dc-82bb-dbf8bd1ece81)
Запускаем туннелирование при помощи `minikube tunnel`
![image](https://github.com/LevKoshevskii/cases/assets/116584865/c01a4967-aa86-4b59-bbcf-e80584bca8ad)
Проверяем работу программы: разбиваем по падежам слово "Контернеризация"
![image](https://github.com/LevKoshevskii/cases/assets/116584865/71e22daf-d38d-408b-bf89-361cb6156f2f)
Устанавливаем helm при помощи `choco install kubernetes-helm`
![image](https://github.com/LevKoshevskii/cases/assets/46699832/101a34fb-4d99-4a69-88db-0356ebf4a553)
Добавлям репозиторий prometheus-community, pull'им его, и запускаем с помощью команд:
`helm repo add prometheus-community https://prometheus-community.github.io/helm-charts`
`helm repo update`
`helm pull prometheus-community/prometheus`
`helm upgrade --install --create-namespace --values prometheus-values.yaml prometheus -n monitoring prometheus-community/prometheus`
Аналогичным образом разворачиваем grafan'у и trickster
![image](https://github.com/LevKoshevskii/cases/assets/46699832/c902106d-f985-4f6e-8bcd-486265551546)
![image](https://github.com/LevKoshevskii/cases/assets/46699832/ad6ea7b0-cc8a-4967-b69c-c51d77bec6ab)
![image](https://github.com/LevKoshevskii/cases/assets/46699832/8ea58d3d-7545-4d7a-bbaf-aee1f8a9087f)
![image](https://github.com/LevKoshevskii/cases/assets/46699832/1d14b2aa-70f2-4bde-8493-ecf33853ae3e)
Для доступа к grafana получаем название название pod'a и пробрасываем к нему порты с помощью команд:
`get pods --namespace monitoring -l "app.kubernetes.io/name=grafana,app.kubernetes.io/instance=grafana" -o jsonpath = "{.items[0].metadata.name}"`
`kubectl --namespace monitoring port-forward grafana-59cf79859c-2bfq5 3000`
![image](https://github.com/LevKoshevskii/cases/assets/46699832/4983d22f-661b-48e3-85bf-e782583a1678)
Заходи в графану по ссылке lochalhost:3000 и создаем ресурс, в адресе указываем адрес trickster
![image](https://github.com/LevKoshevskii/cases/assets/46699832/fdbee351-7376-4e24-ba0a-4f1561b78bdb)
Импортируем готовый dashboard
![image](https://github.com/LevKoshevskii/cases/assets/46699832/0a245f47-66ad-4d5f-a583-d72ff9399385)
С помощью Apache Jmeter сделаем нагрузку на приложение, для проверки работоспособности мониторинга
![image](https://github.com/LevKoshevskii/cases/assets/46699832/679a5c56-ecf1-40f6-9202-3322b289d84b)
Нагрузка на CPU возросла
![image](https://github.com/LevKoshevskii/cases/assets/46699832/28bf847f-c9eb-483a-b036-9bc05eb9ecef)
