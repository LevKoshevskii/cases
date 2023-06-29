# cases

## Abstract
Web-приложение с помощью которого можно просклонять слово по падежам.
Реализовано на языке Kotlin с использованием фрейморка Spring Boot.
Docker-контейнер опубликован Dockerhub: [2651915/cases](https://hub.docker.com/repository/docker/2651915/cases/general).
При push в master ветку докер-контейнер автоматические пересобирается и публикуешься в Dockerhub.
Приложение развёрнуто в k8s кластере с использованием deployment.

## Quick Start
### Docker
Для установки приложения воспользуйтесь образом с Dockerhub:
```
docker pull 2651915/cases:latest
docker run -p 8080:8080 2651915/cases:latest
```

### Kubernetes cluster
1. Установить minikube.
2. Склонировать репозитори.
```
git clone https://github.com/LevKoshevskii/cases
```
3. Запустить minikube.
```
minikube start
```
4. Создать deployment и service.
```
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
```
5. Запустиь режим туннелирования.
```
minikube tunnel
```
Приложение будет доступно [ссылке](http://localhost:8080/).

### Monitoring
Для мониторинга можно использовать prometheus и grafana, а для кэширвоания запросов можно использовать trickster.
Шаги установки:
1. Установить helm.
2. Установка и запуск prometheus:
```
helm repo add prometheus-community https://prometheus-community.github.io/helm-charts
helm repo update
helm pull prometheus-community/prometheus
helm upgrade --install --create-namespace --values prometheus-values.yaml prometheus -n monitoring prometheus-community/prometheus
```
3. Установка и запуск grafana:
```
helm repo add grafana https://grafana.github.io/helm-charts
helm repo update
helm pull grafana/grafana
helm upgrade --install --create-namespace --values grafana-values.yaml grafana -n monitoring grafana/grafana
```
4. Установка и запуск trickster:
```
helm repo add tricksterproxy https://helm.tricksterproxy.io
helm repo update
helm pull tricksterproxy/trickster
helm upgrade --install --create-namespace --values trickster-values.yaml trickster -n monitoring tricksterproxy/trickster
```
5. Для доступа к grafana пробросить порт:
```
get pods --namespace monitoring -l "app.kubernetes.io/name=grafana,app.kubernetes.io/instance=grafana" -o jsonpath = "{.items[0].metadata.name}"
kubectl --namespace monitoring port-forward {результат предыдущей команды} 3000
```
Grafana будет доступна по [ссылке](http://localhost:3000/).

## How to use?
Обратитеть к http://localhost:3000/{word} через адресную строку браузера или postman, заменил {word} на необходимое слово.

## Авторы
* Кошевский Лев
* Герман Илья