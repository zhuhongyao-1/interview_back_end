import requsest from "../js/cishi.js"
export function addtest(value) {
    return requsest({
        url: "http://localhost:3001/subject/selectsubjectall",
        method: "get",
        params: {
            value
        }
    })
}