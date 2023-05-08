import requsest from "../js/cishi.js"
export function paperlist(value) {
    return requsest({
        url: "http://localhost:3001/subject/selectsubjectall",
        method: "get",
        params: {
            value
        }
    })
}


export function answersubject(index) {
    return requsest({
        url: "http://localhost:3001subject/subjectone",
        method: "get",
        params: {
            num: index + 1
        }
    })
}
export function submiterror(errorvalue, answer1error, answer2error, answer3error, answer4error, id) {
    return requsest({
        url: "http://localhost:3001subject/submiterror",
        method: "get",
        params: {
            errorvalue,
            answer1error,
            answer2error,
            answer3error,
            answer4error,
            id
        }
    })
}