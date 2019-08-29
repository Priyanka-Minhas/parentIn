package com.sdei.parentIn.model

import java.util.*

class SurveysModel : BaseModel {

    constructor(message: String) {
        super.message = message
    }

    constructor(statusCode: Int, message: String) {
        super.statusCode = statusCode
        super.message = message
    }

    /**
     * statusCode : 200
     * data : [{"options":["Si","No","no sé"],"min":1,"max":5,"_id":"5d664e191a5e6c425b53f3fd","question":"¿Los niños/as tienen oportunidades para realizar actividades creativas abiertas y sin restricciones? Por ejemplo, ¿pueden proponer juegos y llevarlos a cabo?","language":"es","type":"m","area":"knowledge","helptext":"Si / No / no sé","__v":0},{"options":["Si","No","no sé"],"min":1,"max":5,"_id":"5d664e751a5e6c425b53f3fe","question":"¿Recibes información sobre el desarrollo (en relación a su edad: cómo se mueve, juega, dibuja, se expresa física y verbalmente) tu niño/a?","language":"es","type":"m","area":"knowledge","helptext":"Si / No / no sé","__v":0},{"options":["Si","No","no sé"],"min":1,"max":5,"_id":"5d664ea11a5e6c425b53f3ff","question":"¿A los niños/as se les lee un libro diariamente?","language":"es","type":"m","area":"knowledge","helptext":"Si / No / no sé","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664f191a5e6c425b53f400","question":"¿Qué tan emocionado está tu niño/a a la hora de ir al jardín?","language":"es","type":"s","area":"knowledge","helptext":"Poco / Mucho","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664f611a5e6c425b53f401","question":"¿Cómo se expresa tu niña/o con respecto a sus compañeras/os?","language":"es","type":"s","area":"knowledge","helptext":"Sin emoción / Con Emoción y afecto","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664f7d1a5e6c425b53f402","question":"¿Tú niño/a expresa sentimientos positivos acerca de su referente educativo?","language":"es","type":"s","area":"knowledge","helptext":"Nunca / Siempre","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664fbe1a5e6c425b53f403","question":"¿Consideras que el espacio en el que tu niño/a juega es seguro","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664fcd1a5e6c425b53f404","question":"¿Qué tan variados consideras que son los materiales didácticos con los que cuenta el centro educativo?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664fda1a5e6c425b53f405","question":"¿Cuál consideras que es el estado de estos materiales?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d664feb1a5e6c425b53f406","question":"La organización del mobiliario en el espacio, ¿qué tanto contribuye a reducir las probabilidades de sufrir accidentes?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6650071a5e6c425b53f407","question":"¿Qué tan limpias están las instalaciones? (Esto incluye pisos, paredes, baños, mobiliario)","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6650121a5e6c425b53f408","question":"¿Cuál consideras que es el estado de los pisos y de las paredes?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":["Si","No"],"min":1,"max":5,"_id":"5d6650761a5e6c425b53f409","question":"¿Tiene el Centro Educativo alguna ventana rota?","language":"es","type":"m","area":"look","helptext":"Opción de respuesta: Si / No","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6650881a5e6c425b53f40a","question":"¿Qué tanto consideras que en el Centro Educativo promueve que los niños/as realicen actividades que impliquen movimientos o desplazamiento?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6650a91a5e6c425b53f40b","question":"¿Los espacios con que cuenta el centro permiten a niños y niñas actividades que impliquen movimiento y desplazamiento (saltar, correr, jugar, etc.)?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":["Psicólogo/a","Psicomotricista","Fonoaudiólogo/a","Trabajador/a social","Nutricionista","Docentes de idiomas","Profesor/a de educación física","Profesor/a de música","Psicopedagogo/a","Ninguno","Otro"],"min":1,"max":5,"_id":"5d66511c1a5e6c425b53f40c","question":"¿Qué otros técnicos de apoyo se encuentran disponibles en el Centro Educativo?","language":"es","type":"d","area":"look","helptext":"","__v":0},{"options":["Si","No"],"min":1,"max":5,"_id":"5d66515f1a5e6c425b53f40d","question":"¿Has podido ingresar a la sala donde está tu niño/a en los últimos 2 meses?","language":"es","type":"m","area":"look","helptext":"Opción de respuesta: Si / No","__v":0},{"options":["Si","No"],"min":1,"max":5,"_id":"5d6651711a5e6c425b53f40e","question":"A lo largo del año, ¿ha cambiado el referente educativo de tu niño/a?","language":"es","type":"m","area":"look","helptext":"Opción de respuesta: Si / No","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6651891a5e6c425b53f40f","question":"¿Qué tanto considerás que el personal del Centro Educativo promueve interacciones no violentas, respetuosas y no discriminatorias entre los niños/as?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":["De forma rápida para solucionarlo","De forma reconfortante para los niños/as"],"min":1,"max":5,"_id":"5d6651af1a5e6c425b53f410","question":"Ante un problema, ¿Cómo reacciona el referente educativo?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6651c61a5e6c425b53f411","question":"¿Qué tanto considerás que el referente educativo transmite reglas en forma simple, clara y no violenta, desalentando modelos negativos de relacionamiento?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6651d91a5e6c425b53f412","question":"¿Qué tan efectivas considerás que son las reglas y límites utilizados por el referente educativo?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6651e71a5e6c425b53f413","question":"¿Qué tanto considerás que el referente educativo interpreta las iniciativas de comunicación de tu niño/a (verbales u otro) y responde adecuadamente?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6651f41a5e6c425b53f414","question":"El personal que recibe a tu niño/a la llegada al Centro Educativo, ¿lo saluda de forma afectuosa?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6652021a5e6c425b53f415","question":"¿Cuánto considerás que el personal motiva los niños/as a expresarse?","language":"es","type":"s","area":"look","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6652351a5e6c425b53f416","question":"¿Considera que en el Centro Educativo se ofrecen las mismas propuestas de juego y materiales a niños y niñas?","language":"es","type":"s","area":"discrimination","helptext":"Propuestas diferentes / Mismas propuestas","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6652641a5e6c425b53f417","question":"¿Considera que niños y niñas reciben la misma atención por parte del referente educativo?","language":"es","type":"s","area":"discrimination","helptext":"Atención diferenciada / Misma atención","__v":0},{"options":["en relación a niños y niñas en situación de discapacidad o con barreras para el aprendizaje y la participación?","en relación al nivel sociocultural y económico de las familias?","en relación a aspectos étnicos?","en relación a aspectos religiosos?"],"min":1,"max":5,"_id":"5d6652b51a5e6c425b53f418","question":"¿Considera que el Centro educativo tiene una propuesta de Educación Inclusiva:","language":"es","type":"s","area":"discrimination","helptext":"","__v":0},{"options":[],"min":1,"max":5,"_id":"5d6652db1a5e6c425b53f419","question":"Cómo describirías la relación que como familias tienen con el centro educativo? Respuesta abierta","language":"es","type":"t","area":"discrimination","helptext":"","__v":0}]
     * message : Exitoso
     */

    var data: ArrayList<DataBean>? = null

    class DataBean {
        /**
         * options : ["Si","No","no sé"]
         * min : 1
         * max : 5
         * _id : 5d664e191a5e6c425b53f3fd
         * question : ¿Los niños/as tienen oportunidades para realizar actividades creativas abiertas y sin restricciones? Por ejemplo, ¿pueden proponer juegos y llevarlos a cabo?
         * language : es
         * type : m
         * area : knowledge
         * helptext : Si / No / no sé
         * __v : 0
         */

        var min: Int = 0
        var max: Int = 0
        var _id: String? = null
        var question: String? = null
        var language: String? = null
        var type: String? = null
        var area: String? = null
        var helptext: String? = null
        var __v: Int = 0
        private var options: ArrayList<String>? = null

        fun getOptions(): List<String>? {
            return options
        }

        fun setOptions(options: ArrayList<String>) {
            this.options = options
        }
    }
}
