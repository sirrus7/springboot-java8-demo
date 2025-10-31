package hello.controller;

import hello.model.Topic;
import hello.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * REST controller for managing Topic resources.
 * Provides endpoints for CRUD operations and filtering/sorting of topics.
 */
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    /**
     * Get all Topic
     * @return list of all topics
     */
    @RequestMapping("/topic")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    /**
     * get Topic with ID
     * @param id the topic identifier
     * @return the topic with the specified ID
     */
    @RequestMapping("/topic/{id}")
    public Topic getTopicWithID(@PathVariable String id) {
        return topicService.getTopicWithId(id);
    }

    /**
     * Add a new topic in list
     * @param topic the topic to add
     */
    @PostMapping("/topic")
    public void addTopic(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }

    /**
     * Update Topic in List with id
     * @param id the topic identifier
     * @param topic the updated topic data
     */
    @PutMapping("/topic/{id}")
    public void updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        topicService.updateTopic(id, topic);
    }

    /**
     * Delete a topic with ID
     * @param id the topic identifier
     */
    @DeleteMapping("/topic/{id}")
    public void deleteTopic(@PathVariable String id) {
        topicService.deleteTopic(id);
    }

    /**
     * Get all topics with Id length greater then minimum length
     * @param minLength the minimum length filter
     * @return list of topics with ID length greater than minimum
     */
    @RequestMapping(value = "/topic/minimum/length/{minLength}")
    public List<Topic> filterMinimumLengthForId(@PathVariable Integer minLength) {
        return topicService.filterMinimumLengthForId(minLength);
    }

    /**
     * Sort with Id
     * @return list of topics sorted by ID
     */
    @RequestMapping("/topic/sort")
    public List<Topic> sortTopicsWithID() {
        return topicService.sortTopicsWithID();
    }
}